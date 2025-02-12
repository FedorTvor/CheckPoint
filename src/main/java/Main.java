import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Storage storage = Storage.getInstance();


        Menu menu = new Menu();
        menu.reopen_after_submenu_closes=true;
        menu.addAction("1", "Заполнение массива объектов вручную", new ManuallyFillArrayAction());
        menu.addAction("2", "Создание массива объектов с рандомными значениями", new RandomFillArrayAction());
        menu.addAction("3", "Вывод массива объектов на экран", new PrintArrayAction());
        menu.addAction("4", "Сортировка массива", null);//TODO
        menu.addAction("5", "Выход", null);

        menu.execute();
    }
}
