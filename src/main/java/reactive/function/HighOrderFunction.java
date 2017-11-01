package reactive.function;

import java8.in.action.chapter3.function.Function;

import java.util.function.Supplier;

public class HighOrderFunction {

    public static Supplier<String> createCombineAndTransform(String s1, String s2, Function<String, String> transformer) {
        return () -> {
            String aa = s1;
            String bb = s2;
            if (transformer != null) {
                aa = transformer.apply(aa);
                bb = transformer.apply(bb);
            }
            return aa + bb;
        };
    }

    public static void main(String[] args) {
        Supplier<String> xFormOperation = createCombineAndTransform("Hello ", "world!", s -> s.toUpperCase());
        System.out.println(xFormOperation.get());
    }
}
