import java.util.Arrays;
import java.util.Scanner;
import java.lang.Integer;
import java.lang.String;
import java.util.function.Function;

public class Main {
    public static enum datatype{
        CAR,
        BOOK,
        ROOTVEGETABLE
    }
    public static void main(String[] args) {
        Menu print_array_menu=new Menu();
        print_array_menu.prelude="Выберите тип данных";
        print_array_menu.addAction("1", "Автомобиль",new PrintArrayAction<Car>(datatype.CAR));
        print_array_menu.addAction("2", "Книга",new PrintArrayAction<Book>(datatype.BOOK));
        print_array_menu.addAction("3", "Корнепллод",new PrintArrayAction<RootVegetable>(datatype.ROOTVEGETABLE));
        print_array_menu.addAction("0", "Отмена", null);
        
        Menu search_menu=new Menu();
        
        CustomComparator<Integer> IntComp=(Integer a, Integer b)->(b-a);
        CustomComparator<String> StrComp=(String a, String b)->(a.compareTo(b));
        
        Function<String,Integer> Str2Int=(String str) ->(Integer.parseInt(str));
        Function<String,String> Str2Str=(String str) ->(str);
        
        search_menu.prelude="Выберите тип данных";
        search_menu.addAction("1", "Автомобиль",new Menu().
            addAction("1", "По году", new SearchAction().
                setGetter(new YearOfCar()).
                setComp(IntComp).
                setParser(Str2Int).setSelector(datatype.CAR)
            ).
            addAction("2", "По мощности", new SearchAction().
                setGetter(new PowerOfCar()).
                setComp(IntComp).
                setParser(Str2Int).setSelector(datatype.CAR)
            ).addAction("3", "По модели", new SearchAction().
                setGetter(new YearOfCar()).
                setComp(StrComp).
                setParser(Str2Str).setSelector(datatype.CAR)
            ).addAction("0", "Отмена", null)
        );
        search_menu.addAction("2", "Книга",new Menu().
            addAction("1", "По названию", new SearchAction()
                .setGetter(new TitleOfBook())
                .setComp(StrComp)
                .setParser(Str2Str).setSelector(datatype.BOOK)
            ).addAction("2", "По автору", new SearchAction()
                .setGetter(new AuthorOfBook())
                .setComp(StrComp)
                .setParser(Str2Str).setSelector(datatype.BOOK)
            ).addAction("3", "По страницам", new SearchAction().
                setGetter(new PagesOfBook()).
                setComp(IntComp).
                setParser(Str2Int).setSelector(datatype.BOOK)
            ).addAction("0", "Отмена", null)
        );
        search_menu.addAction("3", "Корнепллод", new Menu().
            addAction("1", "По типу", new SearchAction().
                setGetter(new TypeOfRV()).
                setComp(StrComp).
                setParser(Str2Str).setSelector(datatype.ROOTVEGETABLE)
            ).addAction("2", "По цвету", new SearchAction().
                setGetter(new ColourOfRV()).
                setComp(StrComp).
                setParser(Str2Str).setSelector(datatype.ROOTVEGETABLE)
            ).addAction("3", "По весу", new SearchAction().
                setGetter(new WeightOfRV()).
                setComp(IntComp).
                setParser(Str2Int).setSelector(datatype.ROOTVEGETABLE)
            ).addAction("0", "Отмена", null)
        );
        search_menu.addAction("0", "Отмена", null);
        
        Menu menu = new Menu();
        menu.reopen_after_submenu_closes=true;
        menu.addAction("1", "Заполнение массива объектов вручную", new ManuallyFillArrayAction());
        menu.addAction("2", "Создание массива объектов с рандомными значениями", new RandomFillArrayAction());
        menu.addAction("3", "Вывод массива объектов на экран", print_array_menu);
        menu.addAction("4", "Сортировка массива", null);//TODO
        menu.addAction("5", "Поиск объекта по значению", search_menu);
        menu.addAction("0", "Выход", null);

        menu.execute();
    }
}
