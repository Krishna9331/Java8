package java8.in.action.chapter3.function;

import common.vo.Letter;

import java.util.function.Function;

/**
 * Created by mishrk3 on 10/10/2015.
 */
public class FunctionComposer {

    public static String andThenFunction(String text) {
        Function<String, String> addHeader = Letter::addHeader;
        return addHeader.andThen(Letter::checkSpelling)
                .andThen(Letter::addFooter).apply(text);
    }

    public static Integer composeFunction(Integer value) {
        Function<Integer, Integer> add = x -> x + 1;
        Function<Integer, Integer> multiply = x -> x * 2;
        return add.compose(multiply).apply(value);
    }

    public static Integer andThenArithmeticFunction(Integer value) {
        Function<Integer, Integer> add = x -> x + 1;
        Function<Integer, Integer> multiply = x -> x * 2;
        return add.andThen(multiply).apply(value);
    }
}
