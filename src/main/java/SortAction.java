
public class SortAction<T> implements MenuAction{
    Main.datatype selector;

    SortAction(Main.datatype i){
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

        if(selector.equals(Main.datatype.CAR)){
            Sort<Car> carSort = new Sort<>(new CarComporator());
            Car[] cars = new Car[objects.length];
            for (int i = 0; i < objects.length; i++) {
                cars[i] = (Car) objects[i];
            }

            carSort.mergeSort(cars);

            System.out.println("Отсортированные элементы массива:");
            for (Car car : cars) {
                System.out.println(car + " ");
            }
        }
        if(selector.equals(Main.datatype.BOOK)){
            Sort<Book> bookSort = new Sort<>(new BookComporator());
            Book[] books = new Book[objects.length];
            for (int i = 0; i < objects.length; i++) {
                books[i] = (Book) objects[i];
            }

            bookSort.mergeSort(books);

            System.out.println("Отсортированные элементы массива:");
            for (Book book : books) {
                System.out.println(book + " ");
            }
        }
        if(selector.equals(Main.datatype.ROOTVEGETABLE)) {
            Sort<RootVegetable> vegetableSort = new Sort<>(new RootVegetableComporator());
            RootVegetable[] vegetables = new RootVegetable[objects.length];
            for (int i = 0; i < objects.length; i++) {
                vegetables[i] = (RootVegetable) objects[i];
            }

            vegetableSort.mergeSort(vegetables);

            System.out.println("Отсортированные элементы массива:");
            for (RootVegetable vegetable : vegetables) {
                System.out.println(vegetable + " ");
            }

        }
    }
}
