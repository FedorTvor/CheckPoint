import java.util.HashMap;
import java.lang.reflect.Array;
import java.lang.Class;
public class Storage<T> {
    private static HashMap<DataType.datatype, Storage> instances =new HashMap<DataType.datatype, Storage>();//содержит Pair с
    private Object[] objects;

    public Storage() {
        this.objects = new Object[] {};
    }

    public static <T> Storage<T> getInstance(DataType.datatype i){
        Storage<T> instance=instances.get(i);
        if (instance == null) {
            instance = new Storage<T>();
            instances.put(i, instance);
        }
        return instance;
    }

    public void expandArray(int addSize) {
        Object[] newArray = new Object[objects.length + addSize];
        System.arraycopy(objects, 0, newArray, 0, objects.length);
        objects = newArray;
    }

    public T[] getObjects() {
        return (T[]) objects;
    }

}
