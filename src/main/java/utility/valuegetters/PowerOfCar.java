package utility.valuegetters;

import models.Car;

public class PowerOfCar extends ValueGetter<Car, Integer> {
    public java.lang.Integer get(Car car){
        return car.getPower();
    }
}