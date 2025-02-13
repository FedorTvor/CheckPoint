class YearOfCar extends ValueGetter<Car, java.lang.Integer>{
    public java.lang.Integer get(Car car){
        return car.getYearOfProduction();
    }
}