package java8.in.action.chapter3.lambda;

import com.oracle.java8.vo.Apple;
import java8.in.action.chapter3.function.Function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

/**
 * Created by mishrk3 on 10/10/2015.
 */
public class ConstructorReference {

    public static Apple getObjectUsingSupplier() {
        Supplier<Apple> appleSupplier = Apple::new;
        return appleSupplier.get();
    }

    public static Apple getObjectUsingSupplierLambda() {
        Supplier<Apple> appleSupplier = () -> new Apple();
        return appleSupplier.get();
    }

    public static Apple getAppleObjectWithWeightUsingFunctionReference(Double weight) {
        Function<Double, Apple> appleFunction = Apple::new;
        return appleFunction.apply(weight);
    }

    public static Apple getAppleObjectWithWeightUsingFunctionLambda(Double weight) {
        Function<Double, Apple> appleFunction = (w) -> new Apple(w);
        return appleFunction.apply(weight);
    }

    public static List<Apple> generateApplesWithWeight(List<Double> weights) {
        List<Apple> apples = map(weights, Apple::new);
        return apples;
    }

    private static List<Apple> map(List<Double> weights, Function<Double, Apple> appleFunction) {
        List<Apple> result = new ArrayList<>();
        for (Double weight : weights) {
            result.add(appleFunction.apply(weight));
        }
        return result;
    }

    public static Apple getAppleWithNameAndWeightFunctionReference(Double weight, String color){
        BiFunction<Double, String,Apple> appleBiFunction = Apple :: new;
        return appleBiFunction.apply(weight, color);
    }

    public static Apple getAppleWithNameAndWeightFunctionLambda(Double weight, String color){
        BiFunction<Double, String,Apple> appleBiFunction = (w, c) -> new Apple(w, c);
        return appleBiFunction.apply(weight, color);
    }
}
