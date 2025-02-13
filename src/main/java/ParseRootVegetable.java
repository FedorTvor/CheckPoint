import java.util.Map;

public class ParseRootVegetable {
	private final ParserHelper parserHelper = new ParserHelper();

	public RootVegetable parse(String line) {
		Map<String, String> keyValueMap = parserHelper.parseKeyValuePairs(line);
		String type = keyValueMap.get("type");
		String colour = keyValueMap.get("colour");
		Integer weight = parserHelper.parseInteger(keyValueMap.get("weight"));

		return RootVegetable.createInstance(type, colour, weight);
	}
}
