class EvenOddAction implements MenuAction{
    public Main.datatype class_selector;
    private CustomComparator<T> comparator;
    private Function<T, Integer> extractor;
    
    private void execute(){
        if(comporator==null || extractor ==null |class_selector==null){
            throw new Exception("Заполни поля");
        }
        Storage<T> storage= Storage.<T>getInstance(class_selector);
        SortEvenOdd <T> sort= new SortEvenOdd <T>(comparator);
        T[] sortedArray = (T[]) sort.sortEvenOdd(storage.getObjects(), extractor);
        for(T thingy : sortedArray){
            System.out.println(thingy.toString());
        }
    }
}