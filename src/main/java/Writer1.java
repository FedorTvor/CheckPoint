import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class Writer1<T> {
    private File name;

    public Writer1() {
    }

    public Writer1(File name) {
        this.name = name;
    }

    public File getName() {
        return name;
    }

    public void createdFile() {
        try {
            if(this.name.createNewFile()) {
            } else {
                System.out.println(this.name.getName() + "уже имеется");
            }
        } catch (IOException e) {
            System.out.println(this.name + "ошибка создания" + e);
        }
    }
    public <T> void writeText(T[] t, File file) {
        try {
            //
            BufferedWriter bf = new BufferedWriter(new FileWriter(file, true));
            bf.append(Arrays.toString(t));
            bf.newLine();
            bf.close();
        } catch (IOException e) {
            System.out.println(this.name + " ошибка написания " + e);
        }
    }
    public static void deleteFile(String nameFile) {
        File nameFileExample = new File(nameFile);
        if (nameFileExample.exists()) {
            nameFileExample.delete();
        }
    }
}
