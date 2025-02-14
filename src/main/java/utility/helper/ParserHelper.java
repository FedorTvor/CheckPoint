package utility.helper;

import java.util.HashMap;
import java.util.Map;

public class ParserHelper {

	public Map<String, String> parseKeyValuePairs(String line) {
		String content = line.substring(line.indexOf("{") + 1, line.indexOf("}"));
		Map<String, String> keyValueMap = new HashMap<>();
		for (String part : content.split(",")) {
			String[] keyValue = part.split("=");
			if (keyValue.length != 2) {
				continue;
			}
			String key = keyValue[0].trim();
			String value = keyValue[1].trim().replaceAll("'", "");
			keyValueMap.put(key, value);
		}
		return keyValueMap;
	}

	public Integer parseInteger(String value) {
		try {
			return Integer.parseInt(value);
		} catch (NumberFormatException e) {
			System.out.println("Ошибка ввода: " + e);
		}
		return null;
	}
}
