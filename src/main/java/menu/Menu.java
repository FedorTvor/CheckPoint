package menu;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {
    private Map<Integer, MenuAction> actions = new HashMap<>();

    public void addAction(int option, MenuAction action) {
        actions.put(option, action);
    }

    public void display() {
        System.out.println("Выберите действие:");
        System.out.println("1. Загрузка из файла");
        System.out.println("2. Ввод данных в ручную");
        System.out.println("3. Выбор за вас");
        System.out.println("4. Поиск значения");
        System.out.println("5. Вывод данных в консоль");
        System.out.println("0. Завершение программы");

        int choice = getIntInput();
        MenuAction action = actions.get(choice);
        if (action != null) {
            action.execute();
        } else {
            System.out.println("Неверный выбор. Попробуйте снова.");
        }
    }

    private int getIntInput() {
        Scanner scanner = new Scanner(System.in);
        int number;
        while (true) {
            System.out.print("Введите целое число: ");
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                break;
            } else {
                System.out.println("Ошибка: Введено не целое число. Попробуйте снова.");
                scanner.next(); // Очищаем некорректный ввод
            }
        }
        return number;
    }
}
