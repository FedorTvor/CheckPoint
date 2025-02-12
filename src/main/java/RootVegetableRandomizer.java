import java.util.Random;

public class RootVegetableRandomizer {
    private static final String[] TYPES = {"potato", "onion", "daikon", "parsnip",};
    private static final String[] COLOURS = {"yellow", "red", "purple", "white",};
    private static final Integer MIN_WEIGHT = 50;
    private static final Integer MAX_WEIGHT = 300;
    private static final Random RANDOM = new Random();

    public RootVegetable generate() {
        String type = getRandomType();
        String colour = getRandomColour();
        Integer weight = getRandomWeight();

        return new RootVegetable.Builder()
                .setType(type)
                .setColour(colour)
                .setWeight(weight)
                .build();
    }

    private static String getRandomType() {
        int index = RANDOM.nextInt(TYPES.length);
        return TYPES[index];
    }

    private static String getRandomColour() {
        int index = RANDOM.nextInt(COLOURS.length);
        return COLOURS[index];
    }

    private static Integer getRandomWeight() {
        return MIN_WEIGHT + RANDOM.nextInt(MAX_WEIGHT - MIN_WEIGHT + 1);
    }
}
