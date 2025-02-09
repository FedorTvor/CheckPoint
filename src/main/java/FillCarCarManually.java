import java.util.Scanner;

public class FillCarCarManually implements FillCar {

    @Override
    public Car[] fill() {
        Scanner in = new Scanner(System.in);

        System.out.println("Ведите число машин: ");

        int countCar = 0;

        if (in.hasNextInt()) {
            countCar = in.nextInt();
        }

        Car[] cars = new Car[countCar];

        for(int i = 0; i < countCar; i++) {

            in.nextLine();

            System.out.println("Введите мошность: ");
            Integer power = null;
            if (in.hasNextInt()) {
                power = in.nextInt();
                in.nextLine();
            }

            System.out.println("Введите модель: ");
            String model = in.nextLine();

            System.out.println("Введите год выпуска: ");
            Integer year = null;
            if (in.hasNextInt()) {
                year = in.nextInt();
            }

            if(power == null || year == null || model.equals("") || year < 1000 || year > 10000 || power < 0) {
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
