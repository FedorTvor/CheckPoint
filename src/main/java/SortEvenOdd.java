import java.lang.reflect.Array;
import java.util.function.Function;

public class SortEvenOdd <T> {

	private final CustomComparator<T> comparator;
	public SortEvenOdd(CustomComparator<T> comparator) {
		this.comparator = comparator;
	}

	public T[] sortEvenOdd(T[] array, Function<T, Integer> extractor) {
		if (array == null || array.length <= 1) {
			return array;
		}
		int evenCount = 0;
		for (T arr: array) {
			if (extractor.apply(arr) % 2 == 0) {
				evenCount++;
			}
		}
		T[] evenMas = (T[]) Array.newInstance(array.getClass().getComponentType(),evenCount);
		T[] notEvenMas = (T[]) Array.newInstance(array.getClass().getComponentType(),array.length - evenCount);
		int evenStep = 0;
		int notEvenStep = 0;
		for (T arr : array) {
			if (extractor.apply(arr) % 2 == 0) {
				evenMas[evenStep++] = arr;
			} else {
				notEvenMas[notEvenStep++] = arr;
			}
		}
		T[] sortedEvenArray =(T[]) new Sort<>(comparator).mergeSort(evenMas);
		T[] resultArray = (T[]) Array.newInstance(array.getClass().getComponentType(), array.length);
		evenStep = 0;
		notEvenStep = 0;
		for (int i = 0; i < resultArray.length; i++) {
			if (extractor.apply(array[i]) % 2 == 0) {
				resultArray[i] = sortedEvenArray[evenStep++];
			} else {
				resultArray[i] = notEvenMas[notEvenStep++];
			}
		}
		return resultArray;
	}
}
