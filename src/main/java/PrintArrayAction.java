public class PrintArrayAction<T> implements MenuAction {
    Main.datatype selector;
    
    PrintArrayAction(Main.datatype i){
        selector=i;
    }
    
    @Override
    public void execute(){
        Storage<T> storage = Storage.<T>getInstance(selector);
        if (storage.getObjects().length != 0){
            T[] objects = storage.getObjects();

            System.out.println("Элементы массива:");
            for (T value : objects) {
                System.out.println(value + " ");
            }
        }
        System.out.println("Нет объектов данного типа.");
    }
}
