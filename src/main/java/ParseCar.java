public class ParseCar {
	public Car parse(String line) {
		String[] parts = line.substring(line.indexOf("{") + 1, line.indexOf("}")).split(",");
		Integer power = null;
		String model = null;
		Integer year = null;

		for (String part : parts) {
			String[] keyValue = part.split("=");
			String key = keyValue[0].trim();
			String value = keyValue[1].trim().replaceAll("'", "");

			if (key.contains("power")) {
				try {
					power = Integer.parseInt(value);
				} catch (NumberFormatException e) {
				}
			} else if (key.contains("model")) {
				model = value;
			} else if (key.contains("yearOfProduction")) {
				try {
					year = Integer.parseInt(value);
				} catch (NumberFormatException e) {
					throw new RuntimeException(e);
				}
			}
		}
		return new Car.BuildCAr().setPower(power).setModel(model).setYearOfProduction(year).build();
	}
}
