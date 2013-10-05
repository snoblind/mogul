package com.github.snoblind.mogul.demo;

import com.github.snoblind.mogul.Navigator;
import com.github.snoblind.mogul.rhino.Console;
import com.github.snoblind.mogul.rhino.RhinoWindow;
import com.github.snoblind.mogul.rhino.XMLHttpRequestConstructor;
import java.io.IOException;
import java.util.concurrent.Callable;
import jline.console.ConsoleReader;
import org.apache.http.client.HttpClient;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.EcmaError;
import org.mozilla.javascript.EvaluatorException;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.WrappedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.apache.commons.lang.Validate.notNull;
import static org.mozilla.javascript.ScriptableObject.DONTENUM;
import static org.mozilla.javascript.ScriptableObject.defineProperty;
import static org.mozilla.javascript.ScriptableObject.putProperty;

public class Demo implements Callable<Void> {

	private static Logger LOGGER = LoggerFactory.getLogger(Demo.class);

	private static final String EXIT_FUNCTION = "function exit(returnCode) { java.lang.System.exit(returnCode == null ? 0 : returnCode); }";

	private Console console;
	private HttpClient httpClient;
	private Navigator navigator;
	private RhinoWindow window;

	private Demo() {}
	
	public Void call() throws IOException {
		ConsoleReader jline = new ConsoleReader();
		Context context = Context.enter();
		LOGGER.debug("Rhino Context entered.");
		context.initStandardObjects(window);
		LOGGER.debug("Standard objects initialized.");
		putProperty(window, "console", console);
		putProperty(window, "err", System.err);
		putProperty(window, "navigator", navigator);
		putProperty(window, "out", System.out);
		putProperty(window, "window", window);
        defineProperty(window, "XMLHttpRequest", new XMLHttpRequestConstructor(httpClient), DONTENUM);
		LOGGER.debug("Defined console, err, navigator, out, window, and XMLHttpRequest.");
		context.evaluateString(window, EXIT_FUNCTION, null, 0, null);
		LOGGER.debug("Defined exit() function.");
		StringBuilder builder = new StringBuilder();
		String source;
		while ((source = jline.readLine()) != null) {
			LOGGER.debug("Read line: \"{}\".", source);
			if (source.endsWith(".")) {
				builder.append(source.substring(0, source.length() - 1));
				source = builder.toString();
				builder.setLength(0);
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
			else {
				builder.append(source);
			}
		}
		return null;
	}

	public static Builder builder() {
		return new Builder();
	}

	public static class Builder {

		private Console console;
		private HttpClient httpClient;
		private Navigator navigator;
		private RhinoWindow window;
		
		private Builder() {}

		public Demo build() {
			Demo demo = new Demo();
			notNull(demo.console = console, "Console required.");
			notNull(demo.httpClient = httpClient, "HTTP client required.");
			notNull(demo.navigator = navigator, "Navigator required.");
			notNull(demo.window = window, "Window required.");
			return demo;
		}

		public Builder console(Console console) {
			this.console = console;
			return this;
		}

		public Builder httpClient(HttpClient httpClient) {
			this.httpClient = httpClient;
			return this;
		}

		public Builder navigator(Navigator navigator) {
			this.navigator = navigator;
			return this;
		}

		public Builder window(RhinoWindow window) {
			this.window = window;
			return this;
		}
	}
}