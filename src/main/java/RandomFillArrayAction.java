import java.io.File;
import java.util.Scanner;

public class RandomFillArrayAction implements MenuAction {

    @Override
    public void execute(){
        //Storage storage = Storage.getInstance();
        //Object[] objects = storage.getObjects();
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
                    fillArray(scanner,size,Main.datatype.CAR,new CarRandomizer());
                    step = false;
                    break;
                case "2":
                    System.out.println("Выбран Книга");
                    fillArray(scanner,size,Main.datatype.BOOK,new BookRandomizer());
                    step = false;
                    break;
                case "3":
                    System.out.println("Выбран Корнепллод");
                    fillArray(scanner,size,Main.datatype.ROOTVEGETABLE,new RootVegetableRandomizer());
                    step = false;
                    break;
                case "0":
                    step = false;
                    break;
            }
        }

        System.out.println("выход");
    }

    private <T> void fillArray(Scanner scanner, int size, Main.datatype datatype, ItemRandomizer<T> randomizer) {
        Storage<T> storage = Storage.<T>getInstance(datatype);
        int start_index = findFirst(storage, size);
        Object[] objects = storage.getObjects();
        for (int i = start_index; i < objects.length; i++) {
            objects[i] = randomizer.generate();
        }
        String className = datatype.getClassName();
        WriterFile writerFile = new WriterFile<>(new File(className + ".txt"));
        writerFile.createdFile();
        writerFile.writeText(objects);
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
