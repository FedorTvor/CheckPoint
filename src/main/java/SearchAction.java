import java.util.LinkedList;
import java.util.Scanner;
import java.util.function.Function;
import java.lang.String;
import java.lang.Exception;
import java.util.Optional;

class SearchAction<O,V> implements MenuAction{
    //Обрабатывает запрос поиска и выводит результат
    private static Scanner scan= new Scanner(System.in);
    public Main.datatype class_selector;
    public ValueGetter<O,V> getter;
    CustomComparator<V> comp;
    public Function<String,V> parser;
    
    public SearchAction setGetter(ValueGetter<O,V> getter){
        this.getter=getter;
        return this;
    }
    
    public SearchAction setComp(CustomComparator<V> comp){
        this.comp=comp;
        return this;
    }
    
    public SearchAction setParser(Function<String,V> parser){
        this.parser=parser;
        return this;
    }
    
    public SearchAction setSelector(Main.datatype i){
        class_selector=i;
        return this;
    }
    
    public void execute(){
        BinarySearch<O,V> search=new BinarySearch<O,V>();
        Optional<O> result;
        Storage<O> storage= Storage.<O>getInstance(class_selector);
        search=search. new BinarySearchBuilder().
            addObjects(storage.getObjects()).
            setGetter(getter).
            setComparator(comp).build();
        while(true){
            System.out.print("Запрос:");
            String input=scan.nextLine();
            V search_value;
            try{
                search_value=parser.apply(input);
            }catch(Exception e){
                System.out.println(e.toString());
                continue;
            }
            result = search.findObject(search_value);
            if(result.isPresent()){
                break;
            }
            System.out.println("Не найдено");
        }
        System.out.println(result.get().toString());
    }
}