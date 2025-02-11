import java.util.Scanner;

public class FillCarManually implements FillCar {

    @Override
    public Car[] fill() {
        Scanner in = new Scanner(System.in);

        System.out.println("Ведите число машин: ");
        Integer countCar = InputHelp.InputInt(in);

        Car[] cars = null;

        if(countCar != null && countCar > 0) {
            cars = new Car[countCar];
        } else countCar = 0;

        for(int i = 0; i < countCar; i++) {

            System.out.println("Введите мошность: ");
            Integer power = InputHelp.InputInt(in);

            System.out.println("Введите модель: ");
            String model = in.nextLine();

            System.out.println("Введите год выпуска: ");
            Integer year = InputHelp.InputInt(in);

            if (!CheckHelp.carCheck(power, model, year)) {
                System.out.println("Некоректно введённые данные");
                i--;
            } else {
                cars[i] = new Car.BuildCAr()
                        .setModel(model)
                        .setPower(power)
                        .setYearOfProduction(year)
                        .build();
            }
        }
        return cars;
    }
}
