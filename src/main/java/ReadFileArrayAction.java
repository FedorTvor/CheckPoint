
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
            if (pathchek.equals("Car")) {
                Storage<Car> storage= Storage.getInstance(DataType.ClassType.CAR);
                type = Car.class;
            } else if (pathchek.equals("Book")) {
                Storage<Book> storage= Storage.getInstance(DataType.ClassType.BOOK);
                type = Book.class;
            } else if (pathchek.equals("RootVegetable")) {
                Storage<RootVegetable> storage= Storage.getInstance(DataType.ClassType.ROOTVEGETABLE);
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

