package Utility;

import java.util.Scanner;

public class InputHelp {

    public static Integer getIntField(String message, Scanner in) {
        Integer temp = null;
        System.out.println(message);
        if (in.hasNextInt()) {
            temp = in.nextInt();
        }
        in.nextLine();
        return  temp;
    }

    public  static String getStringField(String message, Scanner in) {
        System.out.println(message);
        return in.nextLine();
    }
}
