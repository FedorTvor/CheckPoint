import java.util.Scanner;

public class RandomFillArrayAction implements MenuAction {

    @Override
    public void execute(){
        Scanner scanner = new Scanner(System.in);
        boolean step = true;

        System.out.print("Введите размер массива: ");
        int size = getIntInput(scanner);

        while (step){
            System.out.println("Выберите тип данных для массива:");
            System.out.println("1. Автомобиль");
            System.out.println("2. Книга");
            System.out.println("3. Корнепллод");
            System.out.println("0. Вернуться в главное меню");

            String choice = scanner.next();
            switch (choice) {
                case "1":
                    do{// Записываем рандомные автомобили
                    Storage<Car> storage= Storage.<Car>getInstance(Main.datatype.CAR);
                    int start_index=findFirst(storage,size);
                    Object[] objects = storage.getObjects();
                    ItemRandomizer<Car> carRandomizer = new CarRandomizer();

                    for (int i = start_index; i < objects.length; i++) {
                        objects[i] = carRandomizer.generate();
                    }
                    step = false;
                    }while(false);
                    break;
                case "2":
                    System.out.println("Выбран Книга");
                    do{// Записываем рандомные книги
                    Storage<Book> storage= Storage.<Book>getInstance(Main.datatype.BOOK);
                    int start_index=findFirst(storage,size);
                    Object[] objects = storage.getObjects();
                    ItemRandomizer<Book> bookRandomizer = new BookRandomizer();

                    for (int i = start_index; i < objects.length; i++) {
                        objects[i] = bookRandomizer.generate();
                    }
                    step = false;
                    }while(false);
                    break;
                case "3":
                    System.out.println("Выбран Корнепллод");
                    do{// Записываем рандомные корнеплоды
                    Storage<RootVegetable> storage= Storage.<RootVegetable>getInstance(Main.datatype.ROOTVEGETABLE);
                    int start_index=findFirst(storage,size);
                    Object[] objects = storage.getObjects();
                    ItemRandomizer<RootVegetable> rootVegetableRandomizer = new RootVegetableRandomizer();

                    for (int i = start_index; i < objects.length; i++) {
                        objects[i] = rootVegetableRandomizer.generate();
                    }
                    step = false;
                    }while(false);
                    break;
                case "0":
                    step = false;
                    break;
            }
        }
        System.out.println("выход");
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

    private int getIntInput(Scanner scanner) {
        int number;
        while (true) {
            System.out.print("Введите целое положительное число: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number > 0) {
                    break;
                } else {
                    System.out.println("Ошибка: Введено не целое положительное число. Попробуйте снова.");
                }
            } else {
                System.out.println("Ошибка: Введено не целое положительное число. Попробуйте снова.");
                scanner.next(); // Очистить некорректный ввод
            }
        }
        return number;
    }
}
