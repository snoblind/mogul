package com.github.snoblind.mogul;

import org.w3c.dom.html.HTMLFormElement;

public interface ExtendedHTMLFormElement extends HTMLFormElement, ExtendedHTMLElement {

	EventListener getOnsubmit();
	void setOnsubmit(EventListener onsubmit);
	
	EventListener getOnreset();
	void setOnreset(EventListener onreset);
}
