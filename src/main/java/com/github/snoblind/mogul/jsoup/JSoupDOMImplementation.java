package com.github.snoblind.mogul.jsoup;

import com.github.snoblind.mogul.event.EventDispatcher;
import com.github.snoblind.mogul.event.MapEventDispatcher;
import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;

public class JSoupDOMImplementation implements DOMImplementation {

	public boolean hasFeature(String feature, String version) {
		throw new UnsupportedOperationException();
	}

	public DocumentType createDocumentType(String qualifiedName, String publicId, String systemId) throws DOMException {
		throw new UnsupportedOperationException();
	}

	public Document createDocument(String namespaceURI, String qualifiedName, DocumentType doctype) throws DOMException {
		org.jsoup.nodes.Document document = new org.jsoup.nodes.Document(namespaceURI.toString());
		EventDispatcher eventDispatcher = new MapEventDispatcher();
		return new JSoupDocument(document, eventDispatcher);
	}

	public Object getFeature(String feature, String version) {
		throw new UnsupportedOperationException();
	}
}