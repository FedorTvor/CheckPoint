import java.util.Scanner;

public class ManuallyFillArrayAction implements MenuAction{
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
