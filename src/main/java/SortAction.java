import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SortAction implements MenuAction {

	@Override
	public MenuAction execute() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите путь файла:");
		String path = scanner.next();

		DataType.datatype dataType;
		Storage<?> storage;
		CustomComparator<?> comparator;
		Class<?> type;
		Function<?, Integer> extractor;
		if (path.toLowerCase().endsWith("car.txt")) {
			dataType = DataType.datatype.CAR;
			comparator = new CarComporator();
			type = Car.class;
			extractor = Car::getPower;
			storage = Storage.getInstance(dataType);
		} else if (path.toLowerCase().endsWith("book.txt")) {
			dataType = DataType.datatype.BOOK;
			comparator = new BookComporator();
			type = Book.class;
			extractor = Book::getPages;
			storage = Storage.getInstance(dataType);
		} else if (path.toLowerCase().endsWith("rootvegetable.txt")) {
			dataType = DataType.datatype.ROOTVEGETABLE;
			comparator = new RootVegetableComporator();
			type = RootVegetable.class;
			extractor = RootVegetable::getWeight;
			storage = Storage.getInstance(dataType);
		} else {
			System.out.println("неккоректный тип данных");
			return null;
		}

		if (storage == null || storage.getObjects().length == 0) {
			System.out.println("ошибка массива");
			return null;
		}
		System.out.println("Выберите способ сортировки:\n " +
				"1 Сортировка слиянием.\n" +
				"2 Сортировка по четным числам");
		String choise = scanner.next();
		switch (choise) {
			case "1":
				Sort  sort1 = new Sort<>(comparator);
				Object[] mergesort = sort1.mergeSort(storage.getObjects());
				WriterFile writerFile1 = new WriterFile<>(new File("Mergesort" + type + ".txt"));
				writerFile1.createdFile();
				writerFile1.writeText(mergesort);
				Arrays.stream(mergesort).forEach(System.out::println);
				break;
			case "2":
				SortEvenOdd sort2 = new SortEvenOdd<>(comparator);
				Object[] sortevenodd = sort2.sortEvenOdd(storage.getObjects(),extractor);
				WriterFile writerFile2 = new WriterFile<>(new File("Evenodd" + type + ".txt"));
				writerFile2.createdFile();
				writerFile2.writeText(sortevenodd);
				Arrays.stream(sortevenodd).forEach(System.out::println);
				break;
		}
		return null;
	}
}
