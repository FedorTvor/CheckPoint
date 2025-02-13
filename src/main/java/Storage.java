import java.util.HashMap;
import java.lang.reflect.Array;
import java.lang.Class;
public class Storage<T> {
    private static HashMap<Main.datatype, Storage> instances =new HashMap<Main.datatype, Storage>();//содержит Pair с 
    //private static Storage instances;
    private Object[] objects;

    public Storage() {
        this.objects = new Object[] {};
    }

    public static <T> Storage<T> getInstance(Main.datatype i){
        //Class<T> cl= new T().getClass();//mega ugly hack, but java is really stupid
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
