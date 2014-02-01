package com.github.snoblind.mogul.jsoup;

import com.github.snoblind.mogul.ExtendedHTMLFormElement;

import org.jsoup.nodes.Element;
import org.w3c.dom.Node;
import org.w3c.dom.html.HTMLInputElement;

public class JSoupInputElement extends JSoupElement implements HTMLInputElement {

	public JSoupInputElement(Element element, JSoupDocument ownerDocument) {
		super(element, ownerDocument);
	}

	public String getDefaultValue() {
		throw new UnsupportedOperationException();
	}

	public void setDefaultValue(String defaultValue) {
		throw new UnsupportedOperationException();
	}

	public boolean getDefaultChecked() {
		throw new UnsupportedOperationException();
	}

	public void setDefaultChecked(boolean defaultChecked) {
		throw new UnsupportedOperationException();
	}

	public ExtendedHTMLFormElement getForm() {
		Node parentNode = getParentNode();
		while (parentNode != null) {
			if (parentNode instanceof ExtendedHTMLFormElement) {
				return (ExtendedHTMLFormElement)parentNode;
			}
			parentNode = parentNode.getParentNode();
		}
		return null;
	}

	public String getType() {
		throw new UnsupportedOperationException();
	}

	public String getAccept() {
		throw new UnsupportedOperationException();
	}

	public void setAccept(String accept) {
		throw new UnsupportedOperationException();
	}

	public String getAccessKey() {
		throw new UnsupportedOperationException();
	}

	public void setAccessKey(String accessKey) {
		throw new UnsupportedOperationException();
	}

	public String getAlign() {
		throw new UnsupportedOperationException();
	}

	public void setAlign(String align) {
		throw new UnsupportedOperationException();
	}

	public String getAlt() {
		throw new UnsupportedOperationException();
	}

	public void setAlt(String alt) {
		throw new UnsupportedOperationException();
	}

	public boolean getChecked() {
		throw new UnsupportedOperationException();
	}

	public void setChecked(boolean checked) {
		throw new UnsupportedOperationException();
	}

	public boolean getDisabled() {
		throw new UnsupportedOperationException();
	}

	public void setDisabled(boolean disabled) {
		throw new UnsupportedOperationException();
	}

	public int getMaxLength() {
		throw new UnsupportedOperationException();
	}

	public void setMaxLength(int maxLength) {
		throw new UnsupportedOperationException();
	}

	public String getName() {
		return getAttribute("name");
	}

	public void setName(String name) {
		setAttribute("name", name);
	}

	public boolean getReadOnly() {
		throw new UnsupportedOperationException();
	}

	public void setReadOnly(boolean readOnly) {
		throw new UnsupportedOperationException();
	}

	public String getSize() {
		throw new UnsupportedOperationException();
	}

	public void setSize(String size) {
		throw new UnsupportedOperationException();
	}

	public String getSrc() {
		throw new UnsupportedOperationException();
	}

	public void setSrc(String src) {
		throw new UnsupportedOperationException();
	}

	public int getTabIndex() {
		throw new UnsupportedOperationException();
	}

	public void setTabIndex(int tabIndex) {
		throw new UnsupportedOperationException();
	}

	public String getUseMap() {
		throw new UnsupportedOperationException();
	}

	public void setUseMap(String useMap) {
		throw new UnsupportedOperationException();
	}

	public String getValue() {
		return getAttribute("value");
	}

	public void setValue(String value) {
		setAttribute("value", value);
	}

	public void blur() {
		throw new UnsupportedOperationException();
	}

	public void focus() {
		throw new UnsupportedOperationException();
	}

	public void select() {
		throw new UnsupportedOperationException();
	}

	public void click() {
		throw new UnsupportedOperationException();
	}
}
