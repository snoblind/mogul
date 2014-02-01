package com.github.snoblind.mogul;

import org.w3c.dom.html.HTMLScriptElement;

public interface ExtendedHTMLScriptElement extends HTMLScriptElement, ExtendedHTMLElement {

	boolean isAsync();
	void setAsync(boolean async);
}
