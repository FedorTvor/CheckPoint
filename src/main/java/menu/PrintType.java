package menu;

import models.Book;
import models.Car;
import models.RootVegetable;
import utility.helper.DataType;

public class PrintType implements MenuAction {

	@Override
	public MenuAction execute() {
		Menu print_array_menu=new Menu();
		print_array_menu.prelude="Выберите тип данных";
		print_array_menu.addAction("1", "Автомобиль",new PrintArrayAction<Car>(DataType.datatype.CAR));
		print_array_menu.addAction("2", "Книга",new PrintArrayAction<Book>(DataType.datatype.BOOK));
		print_array_menu.addAction("3", "Корнепллод",new PrintArrayAction<RootVegetable>(DataType.datatype.ROOTVEGETABLE));
		print_array_menu.addAction("0", "Отмена", null);
		print_array_menu.execute();

	return print_array_menu;
	}
}
