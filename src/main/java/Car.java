public class Car {
    private Integer power;
    private String model;
    private Integer yearOfProduction;

    public Car() {
    }


    public Integer getPower() {
        return this.power;
    }

    public String getModel() {
        return model;
    }


    public Integer getYearOfProduction() {
        return yearOfProduction;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", power='" + power + '\'' +
                ", yearOfProduction=" + yearOfProduction +
                '}';
    }


    public static class BuildCAr{
        private Integer power;
        private String model;
        private Integer yearOfProduction;

        public BuildCAr setPower(Integer power) {
            this.power = power;
            return this;
        }

        public BuildCAr setModel(String model) {
            this.model = model;
            return this;
        }

        public BuildCAr setYearOfProduction(Integer yearOfProduction) {
            this.yearOfProduction = yearOfProduction;
            return this;
        }

        public Car build() {
            Car car = new Car();
            car.power = this.power;
            car.model = this.model;
            car.yearOfProduction = this.yearOfProduction;
            return car;
        }
    }

    public static Car createInstance(Integer power, String model, Integer yearOfProduction) {
        return new Car.BuildCAr()
                .setModel(model)
                .setPower(power)
                .setYearOfProduction(yearOfProduction)
                .build();
    }
}


