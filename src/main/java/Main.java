import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Storage storage = Storage.getInstance();


        Menu menu = new Menu();
        menu.addAction(1, new ManuallyFillArrayAction());
        menu.addAction(2, new RandomFillArrayAction());
        menu.addAction(3, new PrintArrayAction());
        menu.addAction(0, new ExitAction());

        menu.display();
    }
}
