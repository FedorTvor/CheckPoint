import java.util.function.Function;

public class SearchHelper extends SearchAction implements MenuAction {
    @Override
    public void execute(){

    }

    public Menu GetSearchMenuItem() {
        Menu search_menu = new Menu();

        CustomComparator<Integer> IntComp = (Integer a, Integer b) -> (b - a);
        CustomComparator<String> StrComp = String::compareTo;

        Function<String, Integer> Str2Int = Integer::parseInt;
        Function<String, String> Str2Str = (String str) -> (str);

        search_menu.prelude = "Выберите тип данных";
        search_menu.addAction("1", "Автомобиль", new Menu().
                addAction("1", "По году", new SearchHelper().
                        setGetter(new CowLevel.YearOfCar()).
                        setComp(IntComp).
                        setParser(Str2Int).setSelector(Main.datatype.CAR)
                ).addAction("2", "По мощности", new SearchHelper().
                        setGetter(new PowerOfCar()).
                        setComp(IntComp).
                        setParser(Str2Int).setSelector(Main.datatype.CAR)
                ).addAction("3", "По модели", new SearchHelper().
                        setGetter(new CowLevel.YearOfCar()).
                        setComp(StrComp).
                        setParser(Str2Str).setSelector(Main.datatype.CAR)
                ).addAction("0", "Отмена", null)
        );
        search_menu.addAction("2", "Книга", new Menu().
                addAction("1", "По названию", new SearchHelper()
                        .setGetter(new TitleOfBook())
                        .setComp(StrComp)
                        .setParser(Str2Str).setSelector(Main.datatype.BOOK)
                ).addAction("2", "По автору", new SearchHelper()
                        .setGetter(new AuthorOfBook())
                        .setComp(StrComp)
                        .setParser(Str2Str).setSelector(Main.datatype.BOOK)
                ).addAction("3", "По страницам", new SearchHelper().
                        setGetter(new PagesOfBook()).
                        setComp(IntComp).
                        setParser(Str2Int).setSelector(Main.datatype.BOOK)
                ).addAction("0", "Отмена", null)
        );
        search_menu.addAction("3", "Корнепллод", new Menu().
                addAction("1", "По типу", new SearchHelper().
                        setGetter(new TypeOfRV()).
                        setComp(StrComp).
                        setParser(Str2Str).setSelector(Main.datatype.ROOTVEGETABLE)
                ).addAction("2", "По цвету", new SearchHelper().
                        setGetter(new ColourOfRV()).
                        setComp(StrComp).
                        setParser(Str2Str).setSelector(Main.datatype.ROOTVEGETABLE)
                ).addAction("3", "По весу", new SearchHelper().
                        setGetter(new WeightOfRV()).
                        setComp(IntComp).
                        setParser(Str2Int).setSelector(Main.datatype.ROOTVEGETABLE)
                ).addAction("0", "Отмена", null)
        );
        search_menu.addAction("0", "Отмена", null);
        return search_menu;
    }
}
