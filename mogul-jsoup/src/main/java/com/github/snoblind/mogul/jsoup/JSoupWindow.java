package com.github.snoblind.mogul.jsoup;

import com.github.snoblind.mogul.AbstractWindow;
import com.github.snoblind.mogul.ApplicationCache;
import com.github.snoblind.mogul.BarProp;
import com.github.snoblind.mogul.Event;
import com.github.snoblind.mogul.EventException;
import com.github.snoblind.mogul.EventListener;
import com.github.snoblind.mogul.External;
import com.github.snoblind.mogul.GlobalEventHandlers;
import com.github.snoblind.mogul.History;
import com.github.snoblind.mogul.Location;
import com.github.snoblind.mogul.Navigator;
import com.github.snoblind.mogul.Window;
import com.github.snoblind.mogul.WindowEventHandlers;
import com.github.snoblind.mogul.event.EventDispatcher;
//import com.github.snoblind.mogul.rhino.RhinoDocument;
import java.beans.PropertyChangeEvent;
import org.jsoup.Connection.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import static java.lang.String.format;
import static org.apache.commons.lang.Validate.notNull;

public class JSoupWindow extends AbstractWindow {

	private static final Logger LOG = LoggerFactory.getLogger(JSoupWindow.class);

	protected final JSoupLocation location;

	protected JSoupDocument document;

	public JSoupWindow(GlobalEventHandlers globalEventHandlers, WindowEventHandlers windowEventHandlers, JSoupLocation location, JSoupDocument document) {
		super(globalEventHandlers, windowEventHandlers);
		notNull(this.location = location);
		notNull(this.document = document);
		document.defaultView = this;
		final JSoupWindow window = this;
		final EventDispatcher eventDispatcher = document.getEventDispatcher();
		location.addLocationListener(new JSoupLocationListener() {

			public void propertyChange(PropertyChangeEvent event) {
				LOG.debug("location.{} changed from \"{}\" to \"{}\".", event.getPropertyName(), event.getOldValue(), event.getNewValue());
			}

			public void responseReceived(JSoupLocation location, Response response) {
				if (LOG.isDebugEnabled()) {
					final int code = response.statusCode();
					final String message = response.statusMessage();
					final String encoding = response.charset();
					final int characterCount = response.body().length();
					LOG.debug(format("Response received. Status code is %d. Status message is %s. Character encoding is %s. Body is %,d characters.", code, message, encoding, characterCount));
				}
			}

			public void documentParsed(JSoupLocation location, org.jsoup.nodes.Document document) {
				throw new UnsupportedOperationException();
//				if (LOG.isDebugEnabled()) {
//					LOG.debug("Document parsed. Title is \"{}\".", document.title());
//				}
//				window.document = new RhinoDocument(document, eventDispatcher);
//				window.document.setDefaultView(window);
			}
		});
	}

	public Document getDocument() {
		return document;
	}

	public Window open(String url, String target, String features, boolean replace) {
		throw new UnsupportedOperationException();
	}

	public Location getLocation() {
		return location;
	}

	public ApplicationCache getApplicationCache() {
		throw new UnsupportedOperationException();
	}

	public BarProp getLocationbar() {
		throw new UnsupportedOperationException();
	}

	public BarProp getMenubar() {
		throw new UnsupportedOperationException();
	}

	public BarProp getPersonalbar() {
		throw new UnsupportedOperationException();
	}

	public BarProp getScrollbars() {
		throw new UnsupportedOperationException();
	}

	public BarProp getStatusbar() {
		throw new UnsupportedOperationException();
	}

	public BarProp getToolbar() {
		throw new UnsupportedOperationException();
	}

	public boolean confirm(String message) {
		throw new UnsupportedOperationException();
	}

	public String getName() {
		throw new UnsupportedOperationException();
	}

	public String getStatus() {
		throw new UnsupportedOperationException();
	}

	public String prompt(String message, String defaultText) {
		throw new UnsupportedOperationException();
	}

	public Element getFrameElement() {
		throw new UnsupportedOperationException();
	}

	public External getExternal() {
		throw new UnsupportedOperationException();
	}

	public History getHistory() {
		throw new UnsupportedOperationException();
	}

	public long getLength() {
		throw new UnsupportedOperationException();
	}

	public Navigator getNavigator() {
		throw new UnsupportedOperationException();
	}

	public Object get(String name) {
		throw new UnsupportedOperationException();
	}

	public Object showModalDialog(String url, Object optionalArgument) {
		throw new UnsupportedOperationException();
	}

	public void alert(String message) {
		throw new UnsupportedOperationException();
	}

	public void blur() {
		throw new UnsupportedOperationException();
	}

	public void close() {
		throw new UnsupportedOperationException();
	}

	public void focus() {
		throw new UnsupportedOperationException();
	}

	public void print() {
		throw new UnsupportedOperationException();
	}

	public void setName(String name) {
		throw new UnsupportedOperationException();
	}

	public void setOpener(Window opener) {
		throw new UnsupportedOperationException();
	}

	public void setStatus(String status) {
		throw new UnsupportedOperationException();
	}

	public void stop() {
		throw new UnsupportedOperationException();
	}

	public Window getFrames() {
		throw new UnsupportedOperationException();
	}

	public Window get(long index) {
		throw new UnsupportedOperationException();
	}

	public Window getOpener() {
		throw new UnsupportedOperationException();
	}

	public Window getParent() {
		throw new UnsupportedOperationException();
	}

	public Window getSelf() {
		throw new UnsupportedOperationException();
	}

	public Window getTop() {
		throw new UnsupportedOperationException();
	}

	public Window getWindow() {
		throw new UnsupportedOperationException();
	}

	public void addEventListener(String type, EventListener listener,
			boolean useCapture) {
		throw new UnsupportedOperationException();
	}

	public void removeEventListener(String type, EventListener listener,
			boolean useCapture) {
		throw new UnsupportedOperationException();
	}

	public boolean dispatchEvent(Event event) throws EventException {
		throw new UnsupportedOperationException();
	}
}
