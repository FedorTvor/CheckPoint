import java.util.Optional;
import java.util.Comparator;
import java.util.List;
import java.lang.String;
import java.util.LinkedList;
import java.util.Collection;
import java.util.Arrays;
import java.lang.reflect.Array;
import java.util.stream.Collectors;

class BinarySearch<O, V>{
    private ValueGetter<O, V> get;
    private CustomComparator<V> comp;
    private O[] arr;//should be sorted
    private String val_name;
    public class BinarySearchBuilder{
        private ValueGetter<O, V> get=null;
        private CustomComparator<V> comp=null;
        private Sort<O> sorter=null;//only needed for building
       // private Sort(O> obj_sorter=null
        private LinkedList<O> list= new LinkedList<O>();
        private String val_name="";
        
        public BinarySearchBuilder setGetter(ValueGetter<O, V> g){
            get=g;
            
            refreshObjSorter();
            
            return this;
        }
        
        private void refreshObjSorter(){
            if (get==null || comp==null){
                return;
            }
            sorter= new Sort<O>(new CompObjectByValue<O,V>(get, comp));
           // System.out.println(sorter.toString());
        }
        
        public BinarySearchBuilder setComparator(CustomComparator<V> comp){
            this.comp=comp;//redo

            refreshObjSorter();
            
            return this;
        }
        
        public BinarySearchBuilder setName(String name){
            val_name=name;
            return this;
        }
        
        public BinarySearchBuilder addObject( O obj){
            list.add(obj);
            return this;
        }
        
        public BinarySearchBuilder addObjects( Collection<O> col){
            list.addAll(col);
            return this;
        }
        
//<<<<<<< HEAD
        public BinarySearchBuilder addObjects( O[] arr){
            Arrays.stream(arr).collect(Collectors.toCollection(() -> list));
            return this;
        }
        
//=======
//>>>>>>> 895dc49871f3377ff0317fb0a8776a0e57dfc991
        public BinarySearchBuilder clearObjects(){
            list.clear();
            return this;
        }
        
        public BinarySearchBuilder replaceObjects( Collection<O> col){
            clearObjects();
            return addObjects(col);
        }
        
//<<<<<<< HEAD
        public BinarySearchBuilder replaceObjects( O[] arr){//this should be generecable, but my googl-fu is failing me
            clearObjects();
            return addObjects(arr);
        }
        
//=======
//>>>>>>> 895dc49871f3377ff0317fb0a8776a0e57dfc991
        public BinarySearch<O,V> build(){
            BinarySearch<O,V> result = new BinarySearch<O,V>();
            
            if (get==null || comp==null){
                //TODO throw
            }
            //System.out.println(list.get(0).toString());
            
            result.get=get;
            result.comp=comp;
            result.val_name=val_name;
            //result.arr =new O[list.size()];
            result.arr= (O[]) Array.newInstance(list.get(0).getClass(),list.size());// list.toArray(arr);
            for (int i=0; i<result.arr.length;i++){
                result.arr[i]=list.get(i);
            }
            //try{
            result.arr=sorter.mergeSort(result.arr);
            //}catch (java.lang.NullPointerException e){
            //    System.out.println(sorter.toString());
            //}
            return result;
        }
    }
    /*
    public BinarySearch(List<O> list, Comparator<V> comparator, ValueGetter<O, V> getter, Sort<O> sorter){
        get=getter;
        comp=comparator;
        arr=list.toArray(arr);
        
        if (sorter != null){
            arr=sorter.mergeSort(arr);
        }
    };*/
    
    public V getValue(int i){
        //returns value of N-th object
        return get.get(arr[i]);
    }
    
    public O getObject(int i){
        //returns N-th object
        return arr[i];
    }
    
    public String getValueString(int i){
        //returns String representation of N-ths object value
        return get.getString(getObject(i));
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
