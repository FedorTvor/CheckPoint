public class RootVegetable {
    private String type;
    private String colour;
    private int weight;

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

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "RootVegetable{" +
                "type='" + type + '\'' +
                ", colour='" + colour + '\'' +
                ", weight=" + weight +
                '}';
    }

    public static RootVegetable collectorClass(String type, String colour, Integer weight) {
        RootVegetable rootVegetables = null;
        if(!CheckHelp.rootVegetableCheck(type, colour, weight)) {
            System.out.println("Невозможно создать корнеплод с такими параметрами");
        } else {
            rootVegetables = new RootVegetable.Builder()
                    .setColour(colour)
                    .setType(type)
                    .setWeight(weight)
                    .build();
        }
        return rootVegetables;
    }

    public static class Builder{
        private String type;
        private String colour;
        private int weight;

        public Builder setType(String type) {
            this.type = type;
            return this;
        }

        public Builder setColour(String colour) {
            this.colour = colour;
            return this;
        }

        public Builder setWeight(int weight) {
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
}
