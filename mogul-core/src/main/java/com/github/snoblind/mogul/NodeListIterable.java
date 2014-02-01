package com.github.snoblind.mogul;

import java.util.Iterator;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import static org.apache.commons.lang.Validate.notNull;

public class NodeListIterable implements Iterable<Node> {

	public static NodeListIterable iterable(NodeList nodeList) {
		return new NodeListIterable(nodeList);
	}

	private final NodeList nodeList;

	public NodeListIterable(NodeList nodeList) {
		notNull(nodeList);
		this.nodeList = nodeList;
	}

	public Iterator<Node> iterator() {
		return new NodeListIterator(nodeList);
	}

}
