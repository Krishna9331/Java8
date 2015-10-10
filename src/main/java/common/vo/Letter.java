package common.vo;

/**
 * Created by mishrk3 on 10/10/2015.
 */
public class Letter {
    public static String addHeader(String text) {
        return "From Krishna: " + text;
    }

    public static String addFooter(String text) {
        return text + " Kind regards";
    }

    public static String checkSpelling(String text) {
        return text.replaceAll("labda", "lambda");
    }
}
