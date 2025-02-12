public class ParseRootVegetable {
	public RootVegetable parse(String line) {
		String[] parts = line.substring(line.indexOf("{") + 1, line.indexOf("}")).split(",");
		String type = null;
		String colour = null;
		Integer weight = null;

		for (String part : parts) {
			String[] keyValue = part.split("=");
			String key = keyValue[0].trim();
			String value = keyValue[1].trim().replaceAll("'", "");

			if (key.contains("type")) {
				type = value;
			} else if (key.contains("colour")) {
				colour = value;
			} else if (key.contains("weight")) {
				try {
					weight = Integer.parseInt(value);
				} catch (NumberFormatException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return new RootVegetable.Builder().setType(type).setColour(colour).setWeight(weight).build();
	}
}
