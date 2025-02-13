import java.util.Map;

public class ParseCar {
	private final ParserHelper parserHelper = new ParserHelper();

	public Car parse(String line) {
		Map<String, String> keyValueMap = parserHelper.parseKeyValuePairs(line);
		Integer power = parserHelper.parseInteger(keyValueMap.get("power"));
		String model = keyValueMap.get("model");
		Integer year = parserHelper.parseInteger(keyValueMap.get("yearOfProduction"));

		return Car.createInstance(power,model,year);
	}
}
