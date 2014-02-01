package com.github.snoblind.mogul.rhino;

import com.github.snoblind.mogul.event.EventDispatcher;
import com.github.snoblind.mogul.jsoup.JSoupDocument;

import org.jsoup.nodes.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.html.HTMLCollection;

public class RhinoDocument extends JSoupDocument {

	public RhinoDocument(Document document, EventDispatcher eventDispatcher) {
		super(document, eventDispatcher);
	}

	public NodeList querySelectorAll(String query) {
		return new ScriptableNodeList(super.querySelectorAll(query));
	}

	public HTMLCollection getLinks() {
		return new ScriptableHTMLCollection(super.getLinks());
	}

}
