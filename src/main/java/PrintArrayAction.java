public class PrintArrayAction<T> implements MenuAction {
    DataType.ClassType selector;

    PrintArrayAction(DataType.ClassType i){
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
        } else {
            System.out.println("Нет объектов данного типа.");
        }

        return null;
    }
}