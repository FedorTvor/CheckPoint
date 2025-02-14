package utility.valuegetters;

import java.lang.String;
public abstract class ValueGetter<O, V>{
    abstract public V get(O obj);
    public String getString(O obj){
        return String.valueOf(get(obj));
    } 
}