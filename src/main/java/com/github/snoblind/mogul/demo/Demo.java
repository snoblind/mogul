package com.github.snoblind.mogul.demo;

import com.github.snoblind.mogul.rhino.RhinoWindow;
import java.io.IOException;
import java.util.concurrent.Callable;
import jline.console.ConsoleReader;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.EcmaError;
import org.mozilla.javascript.EvaluatorException;
import org.mozilla.javascript.NativeJavaObject;
import org.mozilla.javascript.Undefined;
import org.mozilla.javascript.WrappedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static org.apache.commons.lang.Validate.notNull;

public class Demo implements Callable<Void> {

	private static Logger LOGGER = LoggerFactory.getLogger(Demo.class);

	private static final String EXIT_FUNCTION = "function exit(returnCode) { java.lang.System.exit(returnCode == null ? 0 : returnCode); }";

	private final Context context;
	private final RhinoWindow window;
	private final ConsoleReader jline;

	public Demo(Context context, RhinoWindow window, ConsoleReader jline) {
		notNull(context);
		notNull(window);
		notNull(jline);
		this.context = context;
		this.window = window;
		this.jline = jline;
	}

	public Void call() throws IOException {
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
}
