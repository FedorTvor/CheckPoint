public class PrintArrayAction implements MenuAction {
    @Override
    public void execute(){
        Storage storage = Storage.getInstance();
        Object[] objects = storage.getObjects();

        System.out.println("Элементы массива:");
        for (Object value : objects) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
