
import java.io.File;
import java.util.Scanner;

class SearchAction implements MenuAction {
	@Override
	public MenuAction execute() {
		Scanner scanner = new Scanner(System.in);
		boolean step = true;
		System.out.println("Введите класс");
		System.out.println("1. Автомобиль");
		System.out.println("2. Книга");
		System.out.println("3. Корнеплод");
		String choisesc = scanner.next();
		String choicestr = choisesc;


		while (step) {
			switch (choicestr) {
				case "1":
					Storage<Car> storage1 = Storage.getInstance(DataType.ClassType.CAR);
					storage1.toString();
					System.out.println("что ищем");
					Car [] masCar = fillArray(scanner, DataType.ClassType.CAR, new FillCarManually());
					if (storage1.getObjects() != null) {
						var bscar = new BinarySearch<>(new CarComporator()).binarySearch(storage1
										.getTObjects(Car.class), masCar[0]);
						if (bscar != -1){
							System.out.println("Найден элемент: " + storage1.getObjects());
						} else {
							System.out.println("Элемент не найден.");
						}
					} else {
						System.out.println("Массив автомобилей пуст или не инициализирован.");
					}
					step = false;
					break;
				case "2":
					Storage<Book> storage2 = Storage.getInstance(DataType.ClassType.BOOK);
					System.out.println("что ищем");
					Book [] masBook = fillArray(scanner, DataType.ClassType.BOOK, new FillBookManually());
					if (storage2.getObjects() != null) {
						int bsBook = new BinarySearch<>(new BookComporator()).binarySearch(storage2
								.getTObjects(Book.class), masBook[0]);
						if (bsBook != -1){
							System.out.println("Найден элемент: " + storage2.getObjects());
						} else {
							System.out.println("Элемент не найден.");
						}
					} else {
						System.out.println("Массив книг пуст или не инициализирован.");
					}
					step = false;
					break;
				case "3":
					Storage<RootVegetable> storage3 = Storage.getInstance(DataType.ClassType.ROOTVEGETABLE);
					System.out.println("что ищем");
					RootVegetable[] rootVegetablesMas = fillArray(scanner, DataType.ClassType.ROOTVEGETABLE, new FillRootVegetableManually());
					if (storage3.getObjects() != null) {
						int bsRootV = new BinarySearch<>(new RootVegetableComporator()).binarySearch(storage3
								.getTObjects(RootVegetable.class), rootVegetablesMas[0]);
						if (bsRootV != -1){
							System.out.println("Найден элемент: " + storage3.getObjects());
						} else {
							System.out.println("Элемент не найден.");
						}
					} else {
						System.out.println("Массив корнеплодов пуст или не инициализирован.");
					}
					step = false;
					break;
				case "0":
					step = false;
					break;
			}
		}
		System.out.println("выход");
		return null;
	}
	private <T> T[] fillArray(Scanner scanner, DataType.ClassType ClassType, Fill<T> filler) {
		Storage<T> storage = Storage.<T>getInstance(ClassType);
		T[] array = filler.fill();
		int start_index = findFirst(storage, array.length);
		Object[] objects = storage.getObjects();
		System.arraycopy(array, 0, objects, start_index, array.length);
		String className = ClassType.getClassName();
		WriterFile writerFile = new WriterFile<>(new File(className + ".txt"));
		writerFile.createdFile();
		writerFile.writeText(objects);
		return array;
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