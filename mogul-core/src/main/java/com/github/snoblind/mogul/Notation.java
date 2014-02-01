package com.github.snoblind.mogul;

import org.w3c.dom.Node;

public interface Notation extends Node {
	String getPublicId();
	String getSystemId();
}
