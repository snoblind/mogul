package com.github.snoblind.mogul.jsoup;

import com.github.snoblind.mogul.ExtendedHTMLElement;

import org.jsoup.nodes.Element;
import org.w3c.dom.DOMException;
import org.w3c.dom.html.HTMLCollection;
import org.w3c.dom.html.HTMLTableSectionElement;

public class JSoupTableSectionElement extends JSoupElement implements HTMLTableSectionElement {

	public JSoupTableSectionElement(Element element, JSoupDocument ownerDocument) {
		super(element, ownerDocument);
	}

	public String getAlign() {
		throw new UnsupportedOperationException();
	}

	public void setAlign(String align) {
		throw new UnsupportedOperationException();
	}

	public String getCh() {
		throw new UnsupportedOperationException();
	}

	public void setCh(String ch) {
		throw new UnsupportedOperationException();
	}

	public String getChOff() {
		throw new UnsupportedOperationException();
	}

	public void setChOff(String chOff) {
		throw new UnsupportedOperationException();
	}

	public String getVAlign() {
		throw new UnsupportedOperationException();
	}

	public void setVAlign(String vAlign) {
		throw new UnsupportedOperationException();
	}

	public HTMLCollection getRows() {
		return collect("> tr");
	}

	public ExtendedHTMLElement insertRow(int index) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public void deleteRow(int index) throws DOMException {
		throw new UnsupportedOperationException();
	}

}
