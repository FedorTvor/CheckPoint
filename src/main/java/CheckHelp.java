public class CheckHelp {
    public static Boolean carCheck(Integer power, String model, Integer year) {
        return power != null && year != null && !model.isEmpty() && year >= 1000 && year <= 10000 && power >= 0;
    }
}
