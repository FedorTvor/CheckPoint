package Utility;

public class CheckHelp {
    public static Boolean carCheck(Integer power, String model, Integer year) {
        return power != null && year != null && !model.isEmpty() && year >= 1000 && year <= 10000 && power >= 0;
    }

    public static Boolean bookCheck(String author, String title, Integer pages) {
        return  pages != null && !author.isEmpty() && !title.isEmpty() && pages > 0;
    }

    public static Boolean rootVegetableCheck(String type, String colour, Integer weight) {
        return  weight != null && !type.isEmpty() && !colour.isEmpty() && weight > 0;
    }
}
