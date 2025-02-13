package Utility;

import java.util.HashMap;

public class Storage<T> {
    private static HashMap<TempClass.datatype, Storage> instances =new HashMap<TempClass.datatype, Storage>();//содержит Utility.Pair с
    //private static Utility.Storage instances;
    private Object[] objects;

    public Storage() {
        this.objects = new Object[] {};
    }

    public static <T> Storage<T> getInstance(TempClass.datatype i){
        //Class<T> cl= new T().getClass();//mega ugly hack, but java is really stupid
        Storage<T> instance=instances.get(i);
        if (instance == null) {
            instance = new Storage<T>();
            instances.put(i, instance);
        }
        return instance;
    }

    public void expandArray(int addSize) {
        Object[] newArray = new Object[objects.length + addSize];///*(T[])*/ Array.newInstance(new Class<T>(),objects.length + addSize);//new T[objects.length + addSize];
        System.arraycopy(objects, 0, newArray, 0, objects.length);
        objects = newArray;
    }

    public T[] getObjects() {
        return (T[]) objects;
    }
}
