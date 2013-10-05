package com.github.snoblind.mogul.demo;

import com.github.snoblind.mogul.GlobalEventHandlers;
import com.github.snoblind.mogul.Navigator;
import com.github.snoblind.mogul.WindowEventHandlers;
import com.github.snoblind.mogul.rhino.Console;
import com.github.snoblind.mogul.rhino.PrintStreamConsole;
import com.github.snoblind.mogul.rhino.RhinoNavigator;
import com.github.snoblind.mogul.rhino.RhinoWindow;
import com.github.snoblind.mogul.rhino.RhinoWindowEnvironment;
import com.github.snoblind.mogul.rhino.XMLHttpRequestConstructor;
import java.io.IOException;
import java.util.Timer;
import jline.console.ConsoleReader;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.EcmaError;
import org.mozilla.javascript.EvaluatorException;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.WrappedException;

public class Main {

	private static final String EXIT_FUNCTION = "function exit(returnCode) { java.lang.System.exit(returnCode == null ? 0 : returnCode); }";
	private static final String INITIAL_URL = "http://www.w3.org/TR/html5/";
	
	private static final Answer<Object> ANSWER_UNSUPPORTED_OPERATION = new Answer<Object>() {
		public Object answer(InvocationOnMock invocation) throws Throwable {
			throw new UnsupportedOperationException(invocation.getMethod().toString());
		}
	};

	public static void main(String[] args) throws IOException {
		Timer timer = new Timer();
		HttpClient httpClient = new DefaultHttpClient();
		GlobalEventHandlers globalEventHandlers = Mockito.mock(GlobalEventHandlers.class, ANSWER_UNSUPPORTED_OPERATION);
		WindowEventHandlers windowEventHandlers = Mockito.mock(WindowEventHandlers.class, ANSWER_UNSUPPORTED_OPERATION);
		Navigator navigator = new RhinoNavigator();
		Console console = new PrintStreamConsole();
		try {
			RhinoWindowEnvironment environment = new RhinoWindowEnvironment(timer, console, globalEventHandlers, windowEventHandlers);
			RhinoWindow window = environment.open(INITIAL_URL, null, null, false);
			ConsoleReader jline = new ConsoleReader();
			try {
				Context context = Context.enter();
				context.initStandardObjects(window);
		        ScriptableObject.defineProperty(window, "XMLHttpRequest", new XMLHttpRequestConstructor(httpClient), ScriptableObject.DONTENUM);
				ScriptableObject.putProperty(window, "console", console);
				ScriptableObject.putProperty(window, "navigator", navigator);
				ScriptableObject.putProperty(window, "window", window);
				context.evaluateString(window, EXIT_FUNCTION, null, 0, null);
				String source;
				while ((source = jline.readLine()) != null) {
					try {
						Object returnValue = context.evaluateString(window, source, null, 0, null);
						if (returnValue == null) {
						}
						else if (returnValue instanceof Undefined) {
						}
						else if (returnValue instanceof NativeJavaObject) {
							jline.println(Context.jsToJava(returnValue, String.class).toString());
							jline.flush();
						}
						else {
							jline.println(returnValue.toString());
							jline.flush();
						}
					}
					catch (EcmaError x) {
						System.err.println(x.getMessage());
					}
					catch (WrappedException x) {
						System.err.println(x.getWrappedException());
					}
					catch (EvaluatorException x) {
						System.err.println(x.getMessage());
					}
				}
			}
			finally {
				System.out.print("Exiting Rhino context ...");
				Context.exit();
				System.out.println(" done.");
			}
		}
		catch (Throwable x) {
			x.printStackTrace();
		}
		finally {
			System.out.print("Shutting down HTTP connection manager ...");
			httpClient.getConnectionManager().shutdown();
			System.out.println(" done.");
			System.out.print("Cancelling timer ...");
			timer.cancel();
			System.out.println(" done.");
		}
	}
}