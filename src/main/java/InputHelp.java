import java.util.Scanner;

public class InputHelp {

    public static Integer getInt(String message, Scanner in) {
        Integer temp = null;
        System.out.println(message);
        if (in.hasNextInt()) {
            temp = in.nextInt();
        }
        in.nextLine();
        return  temp;
    }

    public  static String getString(String message, Scanner in) {
        System.out.println(message);
        return in.nextLine();
    }
}
