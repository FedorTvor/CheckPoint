//There is no cow level
import java.util.List;
import java.util.LinkedList;
import java.util.String

class CowLevel{
    static String[] sample_models={
        "Volvo",
        "Mitsubishi",
        "VAZ",
        "BMW",
        "Jeep",//5
        "RGM-79",
        "Tesla",
        "GNU/Car",
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
    }
    static List<Car> DirtyCars(){
        Car.BuildCAr cb = new Car.BuildCAr()
        //Значения получены из кинутых костей, так-что технически они случайны.
        list= new LinkedList<Car>;
        list.add( cb.setPower(12).setYearOfProduction( 7).setModel(sample_models[12]).build());
        list.add( cb.setPower( 4).setYearOfProduction(11).setModel(sample_models[13]).build());
        list.add( cb.setPower(16).setYearOfProduction(20).setModel(sample_models[ 9]).build());
        list.add( cb.setPower(16).setYearOfProduction( 7).setModel(sample_models[ 4]).build());
        return list;
    }
}