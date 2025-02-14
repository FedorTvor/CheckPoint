import java.util.function.Function;

class EvenOddAction<T> implements MenuAction{
    private Main.datatype class_selector;
    private CustomComparator<T> comparator;
    private Function<T, Integer> extractor;
    
    public EvenOddAction setSelector(Main.datatype i){
        class_selector=i;
        return this;
    }
    
    public EvenOddAction setComp(CustomComparator<T> comparator){
        this.comparator=comparator;
        return this;
    }
    
    public EvenOddAction setExtractor(Function<T, Integer> extractor){
        this.extractor=extractor;
        return this;
    }
    
    public void execute(){
        if(comparator==null || extractor ==null |class_selector==null){
            System.out.println("Заполни поля");
        }
        Storage<T> storage= Storage.<T>getInstance(class_selector);
        SortEvenOdd <T> sort= new SortEvenOdd <T>(comparator);
        T[] sortedArray = (T[]) sort.sortEvenOdd(storage.getObjects(), extractor);
        for(T thingy : sortedArray){
            System.out.println(thingy.toString());
        }
    }
}