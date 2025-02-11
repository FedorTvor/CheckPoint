import java.util.Random;

public class CarRandomizer {
    private static final String[] MODELS = {"Ford Bronco", "Haval Jolion", "Audi A3", "Mercedes-Benz V-Class", "Lexus LS"};
    private static final int MIN_POWER = 100;
    private static final int MAX_POWER = 400;
    private static final int MIN_YEAR = 2000;
    private static final int MAX_YEAR = 2025;
    private static final Random RANDOM = new Random();

    public static Car generate(Car car) {
        int power = getRandomPower();
        String model = getRandomModel();
        int year = getRandomYear();

        return new Car.BuildCAr()
                .setPower(power)
                .setModel(model)
                .setYearOfProduction(year)
                .build();
    }

    private static int getRandomPower() {
        return MIN_POWER + RANDOM.nextInt(MAX_POWER - MIN_POWER + 1);
    }

    private static String getRandomModel() {
        int index = RANDOM.nextInt(MODELS.length);
        return MODELS[index];
    }

    private static int getRandomYear() {
        return MIN_YEAR + RANDOM.nextInt(MAX_YEAR - MIN_YEAR + 1);
    }
}
