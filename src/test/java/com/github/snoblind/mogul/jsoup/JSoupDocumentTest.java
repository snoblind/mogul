package com.github.snoblind.mogul.jsoup;

import java.io.IOException;
import org.jsoup.parser.Parser;
import org.junit.Before;
import org.mockito.Mock;
import com.github.snoblind.mogul.ExtendedHTMLDocument;
import com.github.snoblind.mogul.HTMLDocumentTest;
import com.github.snoblind.mogul.Location;
import com.github.snoblind.mogul.Window;
import com.github.snoblind.mogul.jsoup.JSoupDocument;
import com.github.snoblind.mogul.jsoup.JSoupEventDispatcher;

import static org.mockito.Mockito.doReturn;
import static org.mockito.MockitoAnnotations.initMocks;

public class JSoupDocumentTest extends HTMLDocumentTest {

	@Mock private Window window;
	@Mock private Location location;

	@Before
	public void setUp() throws IOException {
		initMocks(this);
		doReturn(location).when(window).getLocation();
		super.setUp();
	}

	protected ExtendedHTMLDocument parseDocument(String html, String baseURI) throws IOException {
		JSoupDocument document = new JSoupDocument(Parser.htmlParser().parseInput(html, baseURI), new JSoupEventDispatcher());
		document.setDefaultView(window);
		return document;
	}
}