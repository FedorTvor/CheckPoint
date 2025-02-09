import java.util.Scanner;

public class InputHelp {

    public static Integer InputInt(Scanner in) {
        Integer temp = null;
        if (in.hasNextInt()) {
            temp = in.nextInt();
        }
        in.nextLine();
        return  temp;
    }
}
