import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean step = true;

        //предложение выбора пользаветюлю
        String[] masString = new String[5];
        masString [0] = "1 Загрузка из файла";
        masString [1] = "2 Ввод данных в ручную";
        masString [2] = "3 Выбор за вас";
        masString [3] = "4 Поиск значения";
        masString [4] = "5 Завершение програмы";

        //Сам цикл с ветвлением и ввод пользователя
        while (step) {
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
                    System.out.println("Введите количество элементов");
                    //Ввод количесвта элементов в массиве
                    int n = scanner.nextInt();
                    Car[] randomCars = new Car[n];
                    //Заполнение масива объектами с рандомными значениями
                    for (int i = 0; i < n; i++) {
                        randomCars[i] = CarRandomizer.generate(new Car());
                    }
                    //Вывод массива
                    for (int i = 0; i < n; i++) {
                        System.out.println(randomCars[i]);
                    }
                    break;
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
}
