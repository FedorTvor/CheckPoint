public class CarComporator implements CustomComparator<Car>{

	@Override
	public int compare(Car car1, Car car2) {
		if (!car1.getModel().equals(car2.getModel())) {
			return car1.getModel().compareTo(car2.getModel());
		} else if (!car1.getPower().equals(car2.getPower())) {
			return CustomComparator.compareINT(car1.getPower(), car2.getPower());
		} else {
			return CustomComparator.compareINT(car1.getYearOfProduction(), car2.getYearOfProduction());
		}
	}
}