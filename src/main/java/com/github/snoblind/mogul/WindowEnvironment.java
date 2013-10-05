package com.github.snoblind.mogul;

import java.io.IOException;

public interface WindowEnvironment {
	Window open(String url, String target, String features, boolean replace) throws IOException;
}
