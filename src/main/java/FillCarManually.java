import java.util.Scanner;

public class FillCarManually implements Fill<Car> {

    @Override
    public Car[] fill() {
        Scanner in = new Scanner(System.in);

        Integer countCar = InputHelp.getInt("Ведите число машин: ", in);

        Car[] cars = null;

        if(countCar != null && countCar > 0) {
            cars = new Car[countCar];
        } else countCar = 0;

        for(int i = 0; i < countCar; i++) {
            Integer power = InputHelp.getInt("Введите мошность: ", in);

            String model = InputHelp.getString("Введите модель: ", in);

            Integer year = InputHelp.getInt("Введите год выпуска: ", in);

            cars[i] = Car.collectorClass(power, model, year);

            if(cars[i] == null) i--;
        }
        return cars;
    }
}
