package com.github.snoblind.mogul.spi;

import com.github.snoblind.mogul.ExtendedHTMLElement;
import org.w3c.dom.Node;

public interface HTMLParser {
	
	String getInnerHTML(ExtendedHTMLElement element);
	void setInnerHTML(ExtendedHTMLElement element, String innerHTML);

	String getOuterHTML(ExtendedHTMLElement element);
	Node setOuterHTML(ExtendedHTMLElement element, String outerHTML);
}
