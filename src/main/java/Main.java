import menu.*;

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.addAction(1, new ReadFromFileAction()); // Вызов меню заполнения массива из файла
        menu.addAction(2, new FillManualAction());   // Вызов меню заполнения массива вручную
        menu.addAction(3, new FillRandomAction());   // Вызов меню заполнения массива случайными данными
        menu.addAction(4, new SearchAction());       // Вызов меню поиска элемента массива
        menu.addAction(5, new PrintAction());        // Вызов меню вывода данных в консоль
        menu.addAction(0, new ExitAction());         // Завершение работы программы

        while (true) {
            menu.display();
            System.out.println();
        }
    }
}
