package com.github.snoblind.mogul.jsoup;

import org.jsoup.nodes.Element;
import org.w3c.dom.html.HTMLAppletElement;

public class JSoupAppletElement extends JSoupElement implements HTMLAppletElement {

	public JSoupAppletElement(Element element, JSoupDocument ownerDocument) {
		super(element, ownerDocument);
	}

	public String getAlign() {
		return getAttribute("align");
	}

	public void setAlign(String align) {
		setAttribute("align", align);
	}

	public String getAlt() {
		return getAttribute("alt");
	}

	public void setAlt(String alt) {
		setAttribute("alt", alt);
	}

	public String getArchive() {
		return getAttribute("archive");
	}

	public void setArchive(String archive) {
		setAttribute("archive", archive);
	}

	public String getCode() {
		return getAttribute("code");
	}

	public void setCode(String code) {
		setAttribute("code", code);
	}

	public String getCodeBase() {
		return getAttribute("codeBase");
	}

	public void setCodeBase(String codeBase) {
		setAttribute("codeBase", codeBase);
	}

	public String getHeight() {
		return getAttribute("height");
	}

	public void setHeight(String height) {
		setAttribute("height", height);
	}

	public String getHspace() {
		return getAttribute("hspace");
	}

	public void setHspace(String hspace) {
		setAttribute("hspace", hspace);
	}

	public String getName() {
		return getAttribute("name");
	}

	public void setName(String name) {
		setAttribute("name", name);
	}

	public String getObject() {
		return getAttribute("object");
	}

	public void setObject(String object) {
		setAttribute("object", object);
	}

	public String getVspace() {
		return getAttribute("vspace");
	}

	public void setVspace(String vspace) {
		setAttribute("vspace", vspace);
	}

	public String getWidth() {
		return getAttribute("width");
	}

	public void setWidth(String width) {
		setAttribute("width", width);
	}
}
