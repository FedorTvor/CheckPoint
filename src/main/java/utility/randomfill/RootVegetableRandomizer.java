package utility.randomfill;

import models.RootVegetable;

import java.util.Random;

public class RootVegetableRandomizer implements ItemRandomizer<RootVegetable> {
    private final String[] types = {"potato", "onion", "daikon", "parsnip",};
    private final String[] colours = {"yellow", "red", "purple", "white",};
    private final Integer minWeight = 50;
    private final Integer maxWeight = 300;
    private final Random random = new Random();

    @Override
    public RootVegetable generate() {
        String type = getRandomType();
        String colour = getRandomColour();
        Integer weight = getRandomWeight();

        return RootVegetable.createInstance(type,colour,weight);
    }

    private String getRandomType() {
        int index = random.nextInt(types.length);
        return types[index];
    }

    private String getRandomColour() {
        int index = random.nextInt(colours.length);
        return colours[index];
    }

    private Integer getRandomWeight() {
        return minWeight + random.nextInt(maxWeight - minWeight + 1);
    }
}
