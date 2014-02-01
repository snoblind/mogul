package com.github.snoblind.mogul.event;

import com.github.snoblind.mogul.Event;
import com.github.snoblind.mogul.EventException;
import com.github.snoblind.mogul.EventListener;
import com.github.snoblind.mogul.EventTarget;

public interface EventDispatcher {
	Event createEvent(String eventInterface);
	boolean dispatchEvent(Event event) throws EventException;
	void addEventListener(EventTarget target, String type, EventListener listener, boolean useCapture);
	void removeEventListener(EventTarget target, String type, EventListener listener, boolean useCapture);
}
