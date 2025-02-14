import java.io.File;
import java.util.Scanner;

public class ManuallyFillArrayAction implements MenuAction {

    @Override
    public MenuAction execute() {
        Scanner scanner = new Scanner(System.in);
        boolean step = true;
        while (step) {
            System.out.println("Выберите тип данных для массива:");
            System.out.println("1. Автомобиль");
            System.out.println("2. Книга");
            System.out.println("3. Корнепллод");
            System.out.println("0. Вернуться в главное меню");
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    fillArray(scanner, DataType.datatype.CAR, new FillCarManually());
                    step = false;
                    break;
                case "2":
                    fillArray(scanner, DataType.datatype.BOOK, new FillBookManually());
                    step = false;
                    break;
                case "3":
                    fillArray(scanner, DataType.datatype.ROOTVEGETABLE, new FillRootVegetableManually());
                    step = false;
                    break;
                case "0":
                    step = false;
                    break;
            }
        }
		return null;
	}

    private <T> void fillArray(Scanner scanner, DataType.datatype datatype, Fill<T> filler) {
        Storage<T> storage = Storage.<T>getInstance(datatype);
        T[] array = filler.fill();
        int start_index = findFirst(storage, array.length);
        Object[] objects = storage.getObjects();
        System.arraycopy(array, 0, objects, start_index, array.length);
        String className = datatype.getClassName();
        WriterFile writerFile = new WriterFile<>(new File(className + ".txt"));
        writerFile.createdFile();
        writerFile.writeText(objects);
    }


    private int findFirst(Storage<? extends Object> storage, int size) {
        Object[] objects = storage.getObjects();
        int startIndex = 0;
        // Найти первое свободное место в массиве
        while (startIndex < objects.length && objects[startIndex] != null) {
            startIndex++;
        }
        // Если места нет увеличиваем размер массива
        if (startIndex >= objects.length) {
            storage.expandArray(size);
            objects = storage.getObjects();
        }
        return startIndex;
    }
}
