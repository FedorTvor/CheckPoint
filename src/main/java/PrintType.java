public class PrintType implements MenuAction {

	@Override
	public MenuAction execute() {
		Menu print_array_menu=new Menu();
		print_array_menu.prelude="Выберите тип данных";
		print_array_menu.addAction("1", "Автомобиль",new PrintArrayAction<Car>(DataType.ClassType.CAR));
		print_array_menu.addAction("2", "Книга",new PrintArrayAction<Book>(DataType.ClassType.BOOK));
		print_array_menu.addAction("3", "Корнепллод",new PrintArrayAction<RootVegetable>(DataType.ClassType.ROOTVEGETABLE));
		print_array_menu.addAction("0", "Отмена", null);
		return print_array_menu;
	}
}
