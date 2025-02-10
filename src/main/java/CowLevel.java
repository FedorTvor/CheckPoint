//There is no cow level
import java.util.List;
import java.util.LinkedList;
import java.lang.String;

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
    };
    static List<Car> DirtyCars(){
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