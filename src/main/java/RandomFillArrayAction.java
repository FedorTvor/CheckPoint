import java.util.Scanner;

public class RandomFillArrayAction implements MenuAction {

    @Override
    public void execute(){
        Storage storage = Storage.getInstance();
        Object[] objects = storage.getObjects();

        Scanner scanner = new Scanner(System.in);
        boolean step = true;
        int startIndex = 0;

        System.out.print("Введите размер массива: ");
        int size = getIntInput(scanner);

        // Найти первое свободное место в массиве
        while (startIndex < objects.length && objects[startIndex] != null) {
            startIndex++;
        }
        // Если места нет увеличиваем размер массива
        if (startIndex >= objects.length) {
            storage.expandArray(size);
            objects = storage.getObjects();
        }

        while (step){
            System.out.println("Выберите тип данных для массива:");
            System.out.println("1. Автомобиль");
            System.out.println("2. Книга");
            System.out.println("3. Корнепллод");
            System.out.println("0. Вернуться в главное меню");

            String choice = scanner.next();
            switch (choice) {
                case "1":
                    ItemRandomizer<Car> carRandomizer = new CarRandomizer();

                    for (int i = startIndex; i < objects.length; i++) {
                        objects[i] = carRandomizer.generate();
                    }
                    step = false;
                    break;
                case "2":
                    System.out.println("Выбран Книга");
                    ItemRandomizer<Book> bookRandomizer = new BookRandomizer();

                    for (int i = startIndex; i < objects.length; i++) {
                        objects[i] = bookRandomizer.generate();
                    }
                    step = false;
                    break;
                case "3":
                    System.out.println("Выбран Корнепллод");

                    ItemRandomizer<RootVegetable> rootVegetableRandomizer = new RootVegetableRandomizer();

                    for (int i = startIndex; i < objects.length; i++) {
                        objects[i] = rootVegetableRandomizer.generate();
                    }
                    step = false;
                    break;
                case "0":
                    step = false;
                    break;
            }
        }
        System.out.println("выход");
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
