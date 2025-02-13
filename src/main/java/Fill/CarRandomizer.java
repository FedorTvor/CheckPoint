package Fill;

import Class.Car;

import java.util.Random;

public class CarRandomizer implements ItemRandomizer<Car> {
    private static final String[] MODELS = {"Ford Bronco", "Haval Jolion", "Audi A3", "Mercedes-Benz V-Class", "Lexus LS"};
    private static final Integer MIN_POWER = 100;
    private static final Integer MAX_POWER = 400;
    private static final Integer MIN_YEAR = 2000;
    private static final Integer MAX_YEAR = 2025;
    private static final Random RANDOM = new Random();

    @Override
    public Car generate() {
        Integer power = getRandomPower();
        String model = getRandomModel();
        Integer year = getRandomYear();

        return Car.createInstance(power, model, year);
    }

    private static Integer getRandomPower() {
        return MIN_POWER + RANDOM.nextInt(MAX_POWER - MIN_POWER + 1);
    }

    private static String getRandomModel() {
        int index = RANDOM.nextInt(MODELS.length);
        return MODELS[index];
    }

    private static Integer getRandomYear() {
        return MIN_YEAR + RANDOM.nextInt(MAX_YEAR - MIN_YEAR + 1);
    }
}
