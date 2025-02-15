import java.util.HashMap;
import java.lang.Class;
public class Storage<T> {
    private static HashMap<DataType.ClassType, Storage> instances =new HashMap<DataType.ClassType, Storage>();//содержит Pair с
    private Object[] objects;
    private static Storage<?> instance;
    private T[] tObjects;

    public Storage() {
        this.objects = new Object[] {};
    }

    public static <T> Storage<T> getInstance(DataType.ClassType i){
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

    public T[] getTObjects(Class<T> type) {
        if (this.tObjects == null) {
            return null;
        }
        if (tObjects.length > 0 && !type.isInstance(tObjects[0])) {
            throw new IllegalArgumentException("Несовместимые типы в хранилище.");
        }
        return tObjects;
    }

}
