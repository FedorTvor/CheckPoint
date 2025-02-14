import java.lang.reflect.Array;
import java.util.function.Function;

public class SortEvenOdd <T> {

	private final CustomComparator<T> comparator;

	public SortEvenOdd(CustomComparator<T> comparator) {
		this.comparator = comparator;
	}

	public T[] sortEvenOdd(T[] array, Class<?> type) {
		Function<Car, Integer> extractor1 = Car::getPower;
		Function<Book, Integer> extractor2 =Book::getPages;
		Function<RootVegetable, Integer> extractor3 = RootVegetable::getWeight;

		if (array == null || array.length <= 1) {
			return array;
		}
		int evenCount = 0;
		if (type == Car.class) {
			for (T arr : array) {
				if (extractor1.apply((Car) arr) % 2 == 0) {
					evenCount++;
				}
			}
		} else if (type == Book.class) {
			for (T arr : array) {
				if (extractor2.apply((Book) arr) % 2 == 0) {
					evenCount++;
				}
			}
		} else if (type == RootVegetable.class) {
			for (T arr : array) {
				if (extractor3.apply((RootVegetable) arr) % 2 == 0) {
					evenCount++;
				}
			}
		}
		T[] evenMas = (T[]) Array.newInstance(array.getClass().getComponentType(), evenCount);
		int evenStep = 0;
		if (type == Car.class) {
			for (T arr : array) {
				if (extractor1.apply((Car) arr) % 2 == 0) {
					evenMas[evenStep] = arr;
					evenStep++;
				}
			}
		} else if (type == Book.class) {
			for (T arr : array) {
				if (extractor2.apply((Book) arr) % 2 == 0) {
					evenMas[evenStep] = arr;
					evenStep++;
				}
			}
		} else if (type == RootVegetable.class) {
			for (T arr : array) {
				if (extractor3.apply((RootVegetable) arr) % 2 == 0) {
					evenMas[evenStep] = arr;
					evenStep++;
				}
			}
		}
		T[] sortedEvenArray = (T[]) new Sort<>(comparator).mergeSort(evenMas);
		T[] resultArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
		evenStep = 0;
		for (int i = 0; i < resultArray.length; i++) {
			if (type == Car.class) {
				if (extractor1.apply((Car) array[i]) % 2 == 0) {
					resultArray[i] = sortedEvenArray[evenStep];
					evenStep++;
				} else {
					resultArray[i] = array[i];
				}
			} else if (type == Book.class) {
				if (extractor2.apply((Book) array[i]) % 2 == 0) {
					resultArray[i] = sortedEvenArray[evenStep];
					evenStep++;
				} else {
					resultArray[i] = array[i];
				}
			} else if (type == RootVegetable.class) {
				if (extractor3.apply((RootVegetable) array[i]) % 2 == 0) {
					resultArray[i] = sortedEvenArray[evenStep];
					evenStep++;
				} else {
					resultArray[i] = array[i];
				}
			}
		}
		return resultArray;
	}
}