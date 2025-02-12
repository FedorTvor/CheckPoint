public class Storage {
    private static Storage instance;
    private Object[] objects;

    public Storage() {
        this.objects = new Object[] {};
    }

    public static Storage getInstance() {
        if (instance == null) {
            instance = new Storage();
        }
        return instance;
    }

    public void expandArray(int addSize) {
        Object[] newArray = new Object[objects.length + addSize];
        System.arraycopy(objects, 0, newArray, 0, objects.length);
        objects = newArray;
    }

    public Object[] getObjects() {
        return objects;
    }
}
