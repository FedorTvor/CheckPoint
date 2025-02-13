package File;
import Class.Book;

public class ParseBook {
	public Book parse(String line) {
		String[] parts = line.substring(line.indexOf("{") + 1, line.indexOf("}")).split(",");
		String author = null;
		String title = null;
		Integer pages = null;

		for (String part : parts) {
			String[] keyValue = part.split("=");
			String key = keyValue[0].trim();
			String value = keyValue[1].trim().replaceAll("'", "");

			if (key.contains("author")) {
				author = value;
			} else if (key.contains("title")) {
				title = value;
			} else if (key.contains("pages")) {
				try {
					pages = Integer.parseInt(value);
				} catch (NumberFormatException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return Book.createInstance(author, title, pages);
	}
}
