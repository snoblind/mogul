package com.github.snoblind.mogul.jsoup;

import org.jsoup.nodes.Node;

public interface NodeFilter {

	boolean accept(Node node);
}
