package com.github.snoblind.mogul.demo;

import java.io.IOException;
import jline.console.ConsoleReader;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.EcmaError;
import org.mozilla.javascript.ScriptableObject;
import org.mozilla.javascript.Undefined;

public class Main {

	public static void main(String[] args) throws IOException {
		try {
			ConsoleReader console = new ConsoleReader();
			Context context = Context.enter();
			ScriptableObject scope = context.initStandardObjects();
			String source;
			while ((source = console.readLine()) != null) {
				try {
					Object returnValue = context.evaluateString(scope, source, null, 0, null);
					if (!(returnValue instanceof Undefined)) {
						console.print(returnValue.toString());
						console.flush();
					}
				}
				catch (EcmaError x) {
					System.err.println(x.getMessage());
				}
			}
		}
		finally {
			Context.exit();
		}
	}
}
