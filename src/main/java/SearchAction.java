import java.util.LinkedList;
import java.util.Scanner;

class SearchAction<O,V> implements MenuAction{
    private static Scanner scan= new Scanner(System.in);
    public Main.datatype class_selector;
    public <ValueGetter<O,V> getter;
    CustomComparator<V> comp;
    
    public SearchAction setGetter(VauleGetter<O,V> getter){
        this.getter=getter;
        return this;
    }
    public SearchAction setComp(CustomComparator<V> comp){
        this.comp=comp;
        return this;
    }
    
    public void execute(){
        BinarySearch<O,V> search=new BinarySearch<O,V>();
        Storage<O> storage= Storage.<O>getInstance(class_selector);
        search=search. new BinarySearchBuilder().addObjects(storage.getObjects()).setGetter(getter).setComp(comp).build();
        System.out.print("Запрос:");
        getter.fromString
        
    }
}