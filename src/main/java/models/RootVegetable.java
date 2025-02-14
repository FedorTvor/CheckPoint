package models;

public class RootVegetable {
    private String type;
    private String colour;
    private static Integer weight;

    public RootVegetable() {
    }

    public RootVegetable(String type, String colour, int weight) {
        this.type = type;
        this.colour = colour;
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public String getColour() {
        return colour;
    }

    public static Integer getWeight() {
        return weight;
    }
    public static Integer getWeight(Object o) {
        return weight;
    }

    @Override
    public String toString() {
        return "models.RootVegetable{" +
                "type='" + type + '\'' +
                ", colour='" + colour + '\'' +
                ", weight=" + weight +
                '}';
    }



    public static class Builder{
        private String type;
        private String colour;
        private Integer weight;

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setColour(String colour) {
            this.colour = colour;
            return this;
        }

        public Builder setWeight(Integer weight) {
            this.weight = weight;
            return this;
        }

        public RootVegetable build(){
            RootVegetable rootVegetable = new RootVegetable();
            rootVegetable.type = this.type;
            rootVegetable.colour = this.colour;
            rootVegetable.weight = this.weight;
            return rootVegetable;
        }
    }

    public static RootVegetable createInstance(String type, String colour, Integer weight) {
        return new RootVegetable.Builder()
                .setColour(colour)
                .setType(type)
                .setWeight(weight)
                .build();
    }
}
