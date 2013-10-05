package com.github.snoblind.mogul.rhino;

import com.github.snoblind.mogul.GlobalEventHandlers;
import com.github.snoblind.mogul.WindowEnvironment;
import com.github.snoblind.mogul.WindowEventHandlers;
import com.github.snoblind.mogul.event.EventDispatcher;
import com.github.snoblind.mogul.jsoup.JSoupEventDispatcher;
import com.github.snoblind.mogul.jsoup.JSoupLocation;

import java.io.IOException;
import java.util.Timer;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import static org.apache.commons.lang.Validate.isTrue;
import static org.apache.commons.lang.Validate.notNull;

public class RhinoWindowEnvironment implements WindowEnvironment {

	protected final Timer timer;
	protected final Console console;
	protected final GlobalEventHandlers globalEventHandlers;
	protected final WindowEventHandlers windowEventHandlers;

	public RhinoWindowEnvironment(Timer timer, Console console, GlobalEventHandlers globalEventHandlers, WindowEventHandlers windowEventHandlers) {
		notNull(this.timer = timer);
		notNull(this.console = console);
		notNull(this.globalEventHandlers = globalEventHandlers);
		notNull(this.windowEventHandlers = windowEventHandlers);
	}

	public RhinoWindow open(String url, String target, String features, boolean replace) throws IOException {
		notNull(url);
		isTrue(target == null && features == null && replace == false);
		final Connection connection = Jsoup.connect(url.toString());
		final JSoupLocation location = new JSoupLocation(connection);
		final EventDispatcher eventDispatcher = new JSoupEventDispatcher();
		final RhinoDocument document = new RhinoDocument(connection.get(), eventDispatcher);
		final RhinoWindow window  = new RhinoWindow(timer, console, globalEventHandlers, windowEventHandlers, location, document);
		return window;
	}
}