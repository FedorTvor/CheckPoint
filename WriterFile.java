import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;

public class WriterFile<T> {
    private File name;

    public WriterFile(File name) {
        this.name = name;
    }

    public File getName() {
        return name;
    }

    public void createdFile() {
        try {
            this.name.createNewFile();
        } catch (IOException e) {
            System.out.println(this.name + "ошибка создания" + e);
        }
    }
    public <T> void writeText(T[] t) {
        try {
            BufferedWriter bf = new BufferedWriter(new FileWriter(this.name, true));
            for (T element : t) {
                bf.append(element.toString());
                bf.newLine();
            }
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
