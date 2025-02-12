import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu{
    private Map<Integer, MenuAction> actions = new HashMap<>();

    public Menu() {
    }

    public void addAction(int option, MenuAction action) {
        actions.put(option, action);
    }

    public void display() {
        while (true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Заполнение массива объектов вручную");
            System.out.println("2. Создание массива объектов с рандомными значениями");
            System.out.println("3. Вывод массива объектов на экран");
            System.out.println("4. Сортировка массива");
            System.out.println("0. Выход");

            int choice = getIntInput();
            MenuAction action = actions.get(choice);
            if (action != null) {
                action.execute();
            } else if (choice == 0) {
                actions.get(0).execute();
            } else {
                System.out.println("Неверный выбор. Попробуйте снова.");
            }
            System.out.println();
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
                scanner.next(); // Очистить некорректный ввод
            }
        }
        return number;

    }
}