import Class.*;
import Menu.PrintArrayAction;
import Menu.ManuallyFillArrayAction;
import Menu.RandomFillArrayAction;
import Menu.Menu;
import Utility.TempClass;

public class Main {

    public static void main(String[] args) {
        //Utility.Storage storage = Utility.Storage.getInstance();

        Menu print_array_menu=new Menu();
        print_array_menu.prelude="Выберите тип данных";
        print_array_menu.addAction("1", "Автомобиль",new PrintArrayAction<Car>(TempClass.datatype.CAR));
        print_array_menu.addAction("2", "Книга",new PrintArrayAction<Book>(TempClass.datatype.BOOK));
        print_array_menu.addAction("3", "Корнепллод",new PrintArrayAction<RootVegetable>(TempClass.datatype.ROOTVEGETABLE));
        print_array_menu.addAction("0", "Отмена", null);
        
        Menu menu = new Menu();
        menu.reopen_after_submenu_closes=true;
        menu.addAction("1", "Заполнение массива объектов вручную", new ManuallyFillArrayAction());
        menu.addAction("2", "Создание массива объектов с рандомными значениями", new RandomFillArrayAction());
        menu.addAction("3", "Вывод массива объектов на экран", print_array_menu);
        menu.addAction("4", "Сортировка массива", null);//TODO
        menu.addAction("5", "Выход", null);

        menu.execute();
    }
}
