package utility.file;

import models.Book;
import utility.helper.ParserHelper;

import java.util.Map;

public class ParseBook {
	private final ParserHelper parserHelper = new ParserHelper();

	public Book parse(String line) {
		Map<String, String> keyValueMap = parserHelper.parseKeyValuePairs(line);
		String author = keyValueMap.get("author");
		String title = keyValueMap.get("title");
		Integer pages = parserHelper.parseInteger(keyValueMap.get("pages"));

		return Book.createInstance(author,title,pages);
	}
}
