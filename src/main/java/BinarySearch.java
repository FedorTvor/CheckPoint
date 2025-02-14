
class BinarySearch<T> {
	private final CustomComparator<T> comparator;

	public BinarySearch(CustomComparator<T> comparator) {
		this.comparator = comparator;
	}
	public int binarySearch(T[] array, T target) {

		if (array == null || array.length == 0) {
			return -1; //
		}

		int low = 0;
		int high = array.length - 1;

		while (low <= high) {
			int mid = low + (high - low) / 2;
			int comparisonResult = comparator.compare(array[mid], target);

			if (comparisonResult == 0) {
				return mid;
			} else if (comparisonResult < 0) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		return -1;
	}
}
