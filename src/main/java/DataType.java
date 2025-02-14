public class DataType {
	public static enum datatype{
		CAR(Car.class),
		BOOK(Book.class),
		ROOTVEGETABLE(RootVegetable.class);
		private final Class<?> clazz;

		datatype(Class<?> clazz) {
			this.clazz = clazz;
		}
		public Class<?> getClazz() {
			return clazz;
		}
		public String getClassName() {
			return clazz.getSimpleName();
		}
	}
}
