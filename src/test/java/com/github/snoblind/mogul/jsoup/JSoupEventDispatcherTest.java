package com.github.snoblind.mogul.jsoup;


import org.mockito.Mockito;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.github.snoblind.mogul.Event;
import com.github.snoblind.mogul.EventListener;
import com.github.snoblind.mogul.ExtendedHTMLElement;
import com.github.snoblind.mogul.jsoup.JSoupEvent;
import com.github.snoblind.mogul.jsoup.JSoupEventDispatcher;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class JSoupEventDispatcherTest {
	
	private JSoupEventDispatcher eventDispatcher;

	@Before
	public void setUp() {
		eventDispatcher = new JSoupEventDispatcher();
	}
	
	@After
	public void tearDown() {
		eventDispatcher = null;
	}
	
	@Test
	public void test1() {
		final ExtendedHTMLElement target = Mockito.mock(ExtendedHTMLElement.class);
		final String type = "click";
		final EventListener listener = Mockito.mock(EventListener.class);
		final boolean useCapture = false;
		eventDispatcher.addEventListener(target, "click", listener, useCapture);
		assertEquals(1, eventDispatcher.getEventListeners(target, type, useCapture).size());
		JSoupEvent event = (JSoupEvent)eventDispatcher.createEvent("Event");
		event.initEvent(type, true, true);
		event.setTarget(target);
		eventDispatcher.dispatchEvent(event);
		Mockito.verify(listener).handleEvent(Mockito.any(Event.class));
		eventDispatcher.removeEventListener(target, type, listener, useCapture);
		assertTrue(eventDispatcher.getEventListeners(target, type, useCapture).isEmpty());
	}
}
