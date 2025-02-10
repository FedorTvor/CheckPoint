package menu;

import models.*;
import util.randomfill.*;

import java.util.Scanner;

public class FillRandomAction implements MenuAction {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Выберите тип данных для массива:");
            System.out.println("1. Автомобиль");
            System.out.println("2. Книга");
            System.out.println("3. Корнепллод");
            System.out.println("0. Выход в главное меню");

            int choice = getIntInput(scanner);
            int size;
            switch (choice) {
                case 1:
                    System.out.println("Введите размер массива:");// Пункт создания массива автомобилей с рандомными значениями
                    size = getIntInput(scanner);
                    Car[] randomCars = new Car[size];
                    for (int i = 0; i < size; i++) {
                        randomCars[i] = CarRandomizer.generate(new Car());
                    }
                    break;
                case 2:
                    System.out.println("Введите размер массива:");// Пункт создания массива книг с рандомными значениями
                    size = getIntInput(scanner);
                    Book[] randomBooks = new Book[size];
                    for (int i = 0; i < size; i++) {
                        randomBooks[i] = BookRandomizer.generate(new Book());
                    }
                    break;
                case 3:
                    System.out.println("Введите размер массива:");// Пункт создания массива корнеплодов с рандомными значениями
                    size = getIntInput(scanner);
                    RootVegetable[] randomVegetables = new RootVegetable[size];
                    for (int i = 0; i < size; i++) {
                        randomVegetables[i] = RootVegetableRandomizer.generate(new RootVegetable());
                    }
                    break;
                case 0:
                    return;// Возвращаемся в главное меню
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
            System.out.println();
        }
    }

    private int getIntInput(Scanner scanner) {
        int number;
        while (true) {
            System.out.print("Введите целое число: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number > 0) {
                    break;
                } else {
                    System.out.println("Ошибка: Введено число, меньшее или равное нулю. Попробуйте снова.");
                }
            } else {
                System.out.println("Ошибка: Введено не целое число. Попробуйте снова.");
                scanner.next(); // Очищаем некорректный ввод
            }
        }
        return number;
    }
}
