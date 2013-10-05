package com.github.snoblind.mogul.rhino;

import org.mozilla.javascript.Scriptable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import static org.apache.commons.lang.Validate.notNull;

public class ScriptableNodeList implements NodeList, Scriptable {

	private static final Logger logger = LoggerFactory.getLogger(ScriptableNodeList.class);

	private final NodeList nodeList;

	public ScriptableNodeList(NodeList nodeList) {
		notNull(this.nodeList = nodeList);
	}

	public Node item(int index) {
		return nodeList.item(index);
	}

	public int getLength() {
		return nodeList.getLength();
	}

	public String getClassName() {
		return getClass().getName();
	}

	public Object get(String name, Scriptable start) {
		logger.debug("get({}, {})", name, start);
		if ("length".equals(name)) {
			return nodeList.getLength();
		}
		throw new UnsupportedOperationException(String.format("get(%s, %s)", name, start));
	}

	public Object get(int index, Scriptable start) {
		logger.debug("get({}, {})", index, start);
		return nodeList.item(index);
	}

	public boolean has(String name, Scriptable start) {
		throw new UnsupportedOperationException();
	}

	public boolean has(int index, Scriptable start) {
		throw new UnsupportedOperationException();
	}

	public void put(String name, Scriptable start, Object value) {
		throw new UnsupportedOperationException();
	}

	public void put(int index, Scriptable start, Object value) {
		throw new UnsupportedOperationException();
	}

	public void delete(String name) {
		throw new UnsupportedOperationException();
	}

	public void delete(int index) {
		throw new UnsupportedOperationException();
	}

	public Scriptable getPrototype() {
		throw new UnsupportedOperationException();
	}

	public void setPrototype(Scriptable prototype) {
		throw new UnsupportedOperationException();
	}

	public Scriptable getParentScope() {
		throw new UnsupportedOperationException();
	}

	public void setParentScope(Scriptable parent) {
		throw new UnsupportedOperationException();
	}

	public Object[] getIds() {
		throw new UnsupportedOperationException();
	}

	public Object getDefaultValue(Class<?> hint) {
		throw new UnsupportedOperationException();
	}

	public boolean hasInstance(Scriptable instance) {
		throw new UnsupportedOperationException();
	}

	public String toString() {
		StringBuilder builder = new StringBuilder("[");
		for (int i = 0; i < nodeList.getLength(); i++) {
			builder.append(nodeList.item(i));
			if (i < nodeList.getLength()) {
				builder.append(", ");
			}
		}
		return builder.append("]").toString();
	}
}
