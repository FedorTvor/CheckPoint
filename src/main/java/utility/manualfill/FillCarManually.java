package utility.manualfill;

import models.Car;
import utility.helper.CheckHelp;
import utility.helper.InputHelp;

import java.util.Scanner;

public class FillCarManually implements Fill<Car> {
    final String MES_COUNT = "Ведите число машин: ";
    final String MES_POWER = "Введите мошность: ";
    final String MES_MODEL = "Введите модель: ";
    final String MES_YEAR = "Введите год выпуска: ";
    final String MES_ERROR_BUILD = "Невозможно создать машину с такими параметрами";

    @Override
    public Car[] fill() {

        Scanner in = new Scanner(System.in);

        Integer countCar = InputHelp.getIntField(MES_COUNT, in);

        Car[] cars = null;

        if(countCar != null && countCar > 0) {
            cars = new Car[countCar];
        } else countCar = 0;

        int j = 0;

        for(int i = 0; i < countCar; i++) {
            Integer power = InputHelp.getIntField(MES_POWER, in);

            String model = InputHelp.getStringField(MES_MODEL, in);

            Integer year = InputHelp.getIntField(MES_YEAR, in);


            if (CheckHelp.carCheck(power, model, year)) {
                cars[j] = Car.createInstance(power, model, year);
                j++;
            } else {
                System.out.println(MES_ERROR_BUILD);
            }
        }

        Car[] cars_result = null;
        if(j > 0) {
            cars_result = new Car[j];
            System.arraycopy(cars, 0, cars_result, 0, j);
        }

        return cars_result;
    }
}
