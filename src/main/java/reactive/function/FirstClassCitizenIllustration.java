package reactive.function;

import java.util.function.BiFunction;

public class FirstClassCitizenIllustration {

    public static String concatFunction(String s1, String s2) {
        return s1 + s2;
    }

    public String concatInstanceFunction(String s1, String s2) {
        return s1 + s2;
    }

    public static void main(String[] args) {
        BiFunction<String, String, String> concat = (s1, s2) -> s1 + s2;
        System.out.println(concat.apply("Hello", " World 1"));

        concat = FirstClassCitizenIllustration::concatFunction;
        System.out.println(concat.apply("Hello", " World 2"));

        FirstClassCitizenIllustration fs = new FirstClassCitizenIllustration();
        concat = fs::concatInstanceFunction;
        System.out.println(concat.apply("Hello", " World 3"));
    }
}
