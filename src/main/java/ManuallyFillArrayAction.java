import java.util.Scanner;

public class ManuallyFillArrayAction implements MenuAction{

    @Override
    public void execute(){
        Scanner scanner = new Scanner(System.in);
        boolean step = true;

        while (step){
            System.out.println("Выберите тип данных для массива:");
            System.out.println("1. Автомобиль");
            System.out.println("2. Книга");
            System.out.println("3. Корнепллод");
            System.out.println("0. Вернуться в главное меню");

            String choice = scanner.next();
            switch (choice) {
                case "1":
                    do{// Ввод автомобилей вручную
                    FillCarManually fillCarManually = new FillCarManually();
                    Car[] cars = fillCarManually.fill();

                    Storage<Car> storage= Storage.<Car>getInstance(Main.datatype.CAR);
                    int start_index=findFirst(storage,cars.length);
                    Object[] objects = storage.getObjects();

                    System.arraycopy(cars, 0, objects, start_index,cars.length);
                    step = false;
                    }while(false);
                    break;
                case "2":
                    do{// Ввод книг вручную
                    FillBookManually fillBookManually = new FillBookManually();
                    Book[] books = fillBookManually.fill();

                    Storage<Book> storage= Storage.<Book>getInstance(Main.datatype.BOOK);
                    int start_index=findFirst(storage,books.length);
                    Object[] objects = storage.getObjects();

                    System.arraycopy(books, 0, objects, start_index,books.length);
                    step = false;
                    }while(false);
                    break;
                case "3":
                    do{// Ввод корнеподов вручную
                    FillRootVegetableManually fillRootVegetableManually = new FillRootVegetableManually();
                    RootVegetable[] vegetables = fillRootVegetableManually.fill();

                    Storage<RootVegetable> storage= Storage.<RootVegetable>getInstance(Main.datatype.ROOTVEGETABLE);
                    int start_index=findFirst(storage,vegetables.length);
                    Object[] objects = storage.getObjects();

                    System.arraycopy(vegetables, 0, objects, start_index,vegetables.length);
                    step = false;
                    }while(false);
                    break;
                case "0":
                    step = false;
                    break;
            }
        }
    }

    private int findFirst(Storage<? extends Object>storage, int size){
        Object[] objects=storage.getObjects();
        int startIndex = 0;
        // Найти первое свободное место в массиве
        while (startIndex < objects.length && objects[startIndex] != null) {
            startIndex++;
        }
        // Если места нет увеличиваем размер массива
        if (startIndex >= objects.length) {
            storage.expandArray(size);
            objects = storage.getObjects();
        }
        return startIndex;
    }
}
