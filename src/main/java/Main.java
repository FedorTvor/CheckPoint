import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean step = true;
        boolean randomSubStep;
        //предложение выбора пользаветюлю
        String[] masString = new String[5];
        masString[0] = "1 Загрузка из файла";
        masString[1] = "2 Ввод данных в ручную";
        masString[2] = "3 Выбор за вас";
        masString[3] = "4 Поиск значения";
        masString[4] = "5 Завершение програмы";

        //Сам цикл с ветвлением и ввод пользователя
        while (step) {
            randomSubStep = true;
            Arrays.stream(masString).forEach(System.out::println);
            String choise = scanner.next();//взаимодействие с пользователем
            switch (choise) {
                case "1":
                    System.out.println("заполнение исходного массив");
                    break;
                case "2":
                    System.out.println("Временно не доступно 2");
                    break;
                case "3":
                    while (randomSubStep) {
                        System.out.println("Выберите тип данных для массива:");
                        System.out.println("1. Автомобиль");
                        System.out.println("2. Книга");
                        System.out.println("3. Корнепллод");
                        System.out.println("4. Выход в главное меню");

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
                            case 4:
                                randomSubStep = false;
                                break;// Возвращаемся в главное меню
                            default:
                                System.out.println("Неверный выбор. Попробуйте снова.");
                        }
                        System.out.println();
                    }
                case "4":
                    System.out.println("Временно не доступно 4");
                    break;
                case "5":
                    System.out.println("Всего доброго");
                    step = false;
                    break;
                default:
                    System.out.println("Выбор некорректный");
            }
        }
    }
    private static int getIntInput(Scanner scanner) {
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
