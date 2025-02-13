package Menu;

import Utility.Storage;
import Utility.TempClass;

public class PrintArrayAction<T> implements MenuAction {
    TempClass.datatype selector;
    
    public PrintArrayAction(TempClass.datatype i){
        selector=i;
    }
    
    @Override
    public void execute(){
        Storage<T> storage = Storage.<T>getInstance(selector);
        if (storage==null){
            System.out.println("Нет объектов данного типа.");
            return;
        }
        T[] objects = storage.getObjects();

        System.out.println("Элементы массива:");
        for (T value : objects) {
            System.out.println(value + " ");
        }
        //System.out.println();
    }
}
