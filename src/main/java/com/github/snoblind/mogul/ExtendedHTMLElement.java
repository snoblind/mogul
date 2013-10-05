package com.github.snoblind.mogul;

import org.w3c.dom.NodeList;
import org.w3c.dom.html.HTMLElement;

public interface ExtendedHTMLElement extends HTMLElement, EventTarget, GlobalEventHandlers, NodeEventHandlers, TouchEventHandlers {
	
	String getInnerHTML();
	void setInnerHTML(String innerHTML);

	String getOuterHTML();
	void setOuterHTML(String outerHTML);

	ExtendedHTMLElement querySelector(String selectors);
	NodeList querySelectorAll(String selectors);
}