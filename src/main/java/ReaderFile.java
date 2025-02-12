import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;

public class ReaderFile {

    public <T> T[] readAndConvert(String filePath, Class<T> type) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        int count = 0;
        String line;
        while ((line = reader.readLine()) != null) {
            count++;
        }
        reader.close();
        T[] objects = (T[]) Array.newInstance(type, count);
        reader = new BufferedReader(new FileReader(filePath)); // Снова открываем файл
        int index = 0;
        while ((line = reader.readLine()) != null) {
            objects[index++] = parseObject(line, type);
        }
        reader.close();
        return objects;
    }
    private <T> T parseObject(String line, Class<T> type) {
        if (type == Car.class) {
            return (T) new ParseCar().parse(line);
        } else if (type == Book.class) {
            return (T) new ParseBook().parse(line);
        } else if (type == RootVegetable.class) {
            return (T) new ParseRootVegetable().parse(line);
        } else {
            throw new IllegalArgumentException("Неподдерживаемый тип: " + type.getName());
        }
    }
}