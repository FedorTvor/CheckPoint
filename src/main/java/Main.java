import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static enum datatype{
        CAR,
        BOOK,
        ROOTVEGETABLE
    }
    public static void main(String[] args) {
        //Storage storage = Storage.getInstance();

        Menu print_array_menu=new Menu();
        print_array_menu.prelude="Выберите тип данных";
        print_array_menu.addAction("1", "Автомобиль",new PrintArrayAction<Car>(datatype.CAR));
        print_array_menu.addAction("2", "Книга",new PrintArrayAction<Book>(datatype.BOOK));
        print_array_menu.addAction("3", "Корнепллод",new PrintArrayAction<RootVegetable>(datatype.ROOTVEGETABLE));
        print_array_menu.addAction("0", "Отмена", null);

        Menu sort_array_menu=new Menu();
        sort_array_menu.prelude="Выберите тип данных";
        sort_array_menu.addAction("1", "Автомобиль",new SortAction<Car>(datatype.CAR));
        sort_array_menu.addAction("2", "Книга",new SortAction<Book>(datatype.BOOK));
        sort_array_menu.addAction("3", "Корнепллод",new SortAction<RootVegetable>(datatype.ROOTVEGETABLE));
        sort_array_menu.addAction("0", "Отмена", null);
        
        Menu menu = new Menu();
        menu.reopen_after_submenu_closes=true;
        menu.addAction("1", "Заполнение массива объектов из файла", null);
        menu.addAction("2", "Заполнение массива объектов вручную", new ManuallyFillArrayAction());
        menu.addAction("3", "Заполнение массива объектов рандомными значениями", new RandomFillArrayAction());
        menu.addAction("4", "Вывод массива объектов на экран", print_array_menu);
        menu.addAction("5", "Сортировка массива", sort_array_menu);//TODO
        menu.addAction("6", "Поиск элемента в массиве", new SearchAction());
        menu.addAction("0", "Выход", new ExitAction());

        menu.execute();
    }
}
