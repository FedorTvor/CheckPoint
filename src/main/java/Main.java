

public class Main {
    public static void main(String[] args) {

        Menu menu = new Menu();
        menu.reopen_after_submenu_closes=true;
        menu.addAction("1", "Заполнение массива объектов из файла", new ReadFileArrayAction());
        menu.addAction("2", "Заполнение массива объектов вручную", new ManuallyFillArrayAction());
        menu.addAction("3", "Заполнение массива объектов рандомными значениями", new RandomFillArrayAction());
        menu.addAction("4", "Вывод массива объектов на экран", new PrintType());
        menu.addAction("5", "Сортировка", new SortAction());
        menu.addAction("7", "Поиск элемента в массиве",new SearchHelper());
        menu.addAction("0", "Выход", new ExitAction());

        menu.execute();

    }
}
