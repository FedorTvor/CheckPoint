import java.util.Optional;
import java.util.Comparator;
import java.util.List;
//TODO change name
class BinarySearch<O, V>{
    private ValueGetter<O, V> get;
    private Comparator<V> comp;
    private O[] arr;//should be sorted
    
    public BinarySearch(List<O> list, Comparator<V> comparator, ValueGetter<O, V> getter,/*TODO change*/ SortStrategy<O> sorter){
        get=getter;
        comp=comparator;
        arr=list.toArray(arr);//TODO make sure it is sorted
        
        if (sorter != null){
            arr=sorter.mergeSort(arr);
        }
    };
    
    public V getValue(int i){
        //returns value of N-th object
        return get.get(arr[i]);
    }
    
    public O getObject(int i){
        //returns N-th object
        return arr[i];
    }
    
    private int compObjVal(int index, V value){//compare object with value
        return comp.compare(getValue(index),value);
    }
    
    private boolean eqObjVal(int index, V value){//equals object with value
        return compObjVal(index,value)==0;
    }
    
    public Optional<O> findObject(V value){
        //returns Optional with either object that has matching value or with nothing if there is no such object 
        int lower_index=0;
        int upper_index=arr.length-1;
        int middle_index;
        
        //make sure that value is in bounds
        if (compObjVal(lower_index,value)>0 || compObjVal(upper_index,value)<0){
            return Optional.empty();
        }
        
        while(upper_index-lower_index>1){
            middle_index=lower_index+(upper_index-lower_index)/2;
            int foo=compObjVal(middle_index, value);
            
            if (foo==0) {
                return Optional.of(getObject(middle_index));
            }
            if (foo<0){
                lower_index=middle_index;
                continue;
            }
            if (foo>0){
                upper_index=middle_index;
                continue;
            }
        }
        
        for(int i=lower_index; i<=upper_index; i++){
            if (eqObjVal(i,value)) {return Optional.of( getObject(i));}
        }
        //TODO we checked that value is in range but didn't found it, throw expection
        return Optional.empty();
    }
}