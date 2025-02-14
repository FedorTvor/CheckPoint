package menu;

import models.Storage;
import utility.file.WriterFile;
import utility.helper.DataType;
import utility.randomfill.BookRandomizer;
import utility.randomfill.CarRandomizer;
import utility.randomfill.ItemRandomizer;
import utility.randomfill.RootVegetableRandomizer;

import java.io.File;
import java.util.Scanner;

public class RandomFillArrayAction implements MenuAction {

    @Override
    public MenuAction execute(){
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
                    System.out.println("Выбраны Автомобили");
                    fillArray(scanner,size, DataType.datatype.CAR,new CarRandomizer());
                    step = false;
                    break;
                case "2":
                    System.out.println("Выбраны Книги");
                    fillArray(scanner,size, DataType.datatype.BOOK,new BookRandomizer());
                    step = false;
                    break;
                case "3":
                    System.out.println("Выбран Корнепллод");
                    fillArray(scanner,size, DataType.datatype.ROOTVEGETABLE,new RootVegetableRandomizer());
                    step = false;
                    break;
                case "0":
                    step = false;
                    break;
            }
        }

        System.out.println("выход");
        return null;
    }

    private <T> void fillArray(Scanner scanner, int size, DataType.datatype datatype, ItemRandomizer<T> randomizer) {
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

    private int findFirst(Storage<? extends Object> storage, int size){
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
