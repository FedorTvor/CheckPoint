import java.util.Comparator;


public interface CustomComparator<T>  {
	public int compare(T o1, T o2);

	public static int compareINT(int x, int y) {
		return (x < y) ? -1 : ((x == y) ? 0 : 1);
	}
}