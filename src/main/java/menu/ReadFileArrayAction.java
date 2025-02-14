package menu;

import models.Book;
import models.Car;
import models.RootVegetable;
import models.Storage;
import utility.file.ReaderFile;
import utility.helper.DataType;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadFileArrayAction implements MenuAction{


    @Override
    public MenuAction execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите путь");
        String path = scanner.next();
        String pathchek = path.substring(0, path.length() - 4);
        Class<?> type;
        var reader = new ReaderFile();

        try {
            if (pathchek.equals("models.Car")) {
                Storage<Car> storage= Storage.getInstance(DataType.datatype.CAR);
                type = Car.class;
            } else if (pathchek.equals("models.Book")) {
                Storage<Book> storage= Storage.getInstance(DataType.datatype.BOOK);
                type = Book.class;
            } else if (pathchek.equals("models.RootVegetable")) {
                Storage<RootVegetable> storage= Storage.getInstance(DataType.datatype.ROOTVEGETABLE);
                type = RootVegetable.class;
            } else {
                System.out.println("Неподдерживаемый тип файла.");
				return null;
            }
            Object[] resultRead =  reader.readAndConvert(path,type);
            Arrays.stream(resultRead).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println("Ошибка компиляции: " + e);;
        }
		return null;
	}
}

