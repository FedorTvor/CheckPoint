public class OddSortAction<T> implements MenuAction {
    Main.datatype selector;

    OddSortAction(Main.datatype i){
        selector=i;
    }

    @Override
    public void execute(){
        Storage<T> storage = Storage.<T>getInstance(selector);
        T[] objects = storage.getObjects();
        if (storage.getObjects().length != 0){

        }
        System.out.println("Нет объектов данного типа");
    }
}
