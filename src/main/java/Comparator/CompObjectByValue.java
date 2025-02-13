package Comparator;
import Utility.ValueGetter;

public class CompObjectByValue<O, V> implements CustomComparator<O>{
    private ValueGetter<O,V> getter;
    private CustomComparator<V> value_comparator;
    public CompObjectByValue(ValueGetter<O,V> getter, CustomComparator<V> value_comparator){
        this.getter=getter;
        this.value_comparator=value_comparator;
    };
    public int compare(O o1, O o2){
        return value_comparator.compare(getter.get(o1), getter.get(o2));
    }
}