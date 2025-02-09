import java.util.Arrays;

public class Sort<T> {
	private final CustomComparator<T> comparator;

	public Sort(CustomComparator<T> comparator) {
		this.comparator = comparator;
	}

    private void merge(T[] src1, int src1Start, T[] src2, int src2Start, T[] dest, int destStart, int size) {
        int index1 = src1Start;
        int index2 = src2Start;
        int src1End = Math.min(src1Start + size, src1.length);
        int src2End = Math.min(src2Start + size, src2.length);
        int iterationalCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationalCount; i++) {
            if (index1 < src1End && (index2 >= src2End || comparator.compare(src1[index1], src2[index2]) < 0)) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    public T[] mergeSort(T[] array) {
        if (array == null || array.length <= 1) {
            return array;
        }

        T[] tmp;
        T[] currentSrc = array;
        T[] currentDest = Arrays.copyOf(array, array.length);
        int size = 1;

        while (size < array.length) {
            for (int i = 0; i < array.length; i += 2 * size) {
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;
            size = size * 2;
        }

        return currentSrc;
    }

}

