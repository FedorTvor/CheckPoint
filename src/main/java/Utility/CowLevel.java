package Utility;
//There is no cow level
import Comparator.CompObjectByValue;
import Comparator.CustomComparator;
import Class.Car;
import Tools.BinarySearch;

import java.util.List;
import java.util.LinkedList;
import java.lang.String;

public class CowLevel{
    static class YearOfCar extends ValueGetter<Car, Integer> {
        public java.lang.Integer get(Car car){
            return car.getYearOfProduction();
        }
    }
    static class IntComp implements CustomComparator<Integer> {
        public int compare(java.lang.Integer o1, java.lang.Integer o2){
            if (o1<o2) return -1;
            if (o1>o2) return 1;
            return 0; 
        }
    }
    static void debugStuff(){
        System.out.println("STUPID DEBUG STUFF");
        YearOfCar getter=new YearOfCar();
        IntComp comp=new IntComp();
        CompObjectByValue<Car, Integer> car_comp=new CompObjectByValue<Car, java.lang.Integer>(getter, comp);
        
        System.out.println("Unsorted cars");
        java.util.List<Car> cars=CowLevel.dirtyCars();
        for (Car c : cars){
            System.out.println(c.toString());
        }
        System.out.println("Sorted cars");
        BinarySearch<Car, Integer> index =new BinarySearch<Car, Integer>();
        BinarySearch<Car, Integer>.BinarySearchBuilder b=index. new BinarySearchBuilder();
        BinarySearch<Car, Integer> ind=b.addObjects(cars).setGetter(getter).setComparator(comp).build();
        for(int i=0;i<cars.size();i++){
            System.out.println(ind.getObject(i).toString());
        }
        System.out.println("Searching cars from year 11");
        System.out.println(ind.findObject(11).toString());
        System.out.println("END OF STUPID DEBUG STUFF");
    }
    static String[] sample_models={
        "Volvo",
        "Mitsubishi",
        "VAZ",
        "BMW",
        "Jeep",//5
        "RGM-79",
        "Tesla",
        "GNU/Class.Car",
        "Metal Gear",
        "Volkswagen",//10
        "General Motors",
        "Sample Text",
        "foo",
        "bar",
        "baz",//15
        "Dodger",
        "Ford",
        "Audi",
        "Chery",
        "Chevrolet"    
    };
    static List<Car> dirtyCars(){
        Car.BuildCAr cb = new Car.BuildCAr();
        //Значения получены из кинутых костей, так-что технически они случайны.
        LinkedList<Car> list= new LinkedList<Car>(List.of(
            cb.setPower(12).setYearOfProduction( 7).setModel(sample_models[12]).build(),
            cb.setPower( 4).setYearOfProduction(11).setModel(sample_models[13]).build(),
            cb.setPower(16).setYearOfProduction(20).setModel(sample_models[ 9]).build(),
            cb.setPower(16).setYearOfProduction( 7).setModel(sample_models[ 4]).build()
        ));
        return list;
    }
}