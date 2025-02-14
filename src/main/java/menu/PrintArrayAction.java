package menu;

import models.Storage;
import utility.helper.DataType;

public class PrintArrayAction<T> implements MenuAction {
    DataType.datatype selector;
    
    PrintArrayAction(DataType.datatype i){
        selector=i;
    }
    
    @Override
    public MenuAction execute(){
        Storage<T> storage = Storage.<T>getInstance(selector);
        if (storage.getObjects().length != 0){
            T[] objects = storage.getObjects();

            System.out.println("Элементы массива:");
            for (T value : objects) {
                System.out.println(value + " ");
            }
            System.out.println("Нет объектов данного типа.");
        }

		return null;
	}
}
