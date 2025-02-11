import java.lang.String;
abstract class ValueGetter<O, V>{
    abstract public V get(O obj);
    public String getString(O obj){
        return String.valueOf(get(obj));
    } 
}