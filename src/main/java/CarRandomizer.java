import java.util.Random;

public class CarRandomizer implements ItemRandomizer<Car>{
    private final String[] models = {"Ford Bronco", "Haval Jolion", "Audi A3", "Mercedes-Benz V-Class", "Lexus LS"};
    private final Integer minPower = 100;
    private final Integer maxPower = 400;
    private final Integer minYear = 2000;
    private final Integer maxYear = 2025;
    private final Random random = new Random();

    @Override
    public Car generate() {
        Integer power = getRandomPower();
        String model = getRandomModel();
        Integer year = getRandomYear();

        return Car.createInstance(power,model,year);
    }

    private Integer getRandomPower() {
        return minPower + random.nextInt(maxPower - minPower + 1);
    }

    private String getRandomModel() {
        int index = random.nextInt(models.length);
        return models[index];
    }

    private Integer getRandomYear() {
        return minYear + random.nextInt(maxYear - minYear + 1);
    }
}
