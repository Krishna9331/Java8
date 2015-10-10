package java8.in.action.chapter3.lambda;

import com.oracle.java8.vo.Apple;

import static java.util.Comparator.comparing;

import java.util.Comparator;
import java.util.List;

/**
 * Created by mishrk3 on 10/10/2015.
 */
public class LambdaReferencePractice {

    public static class AppleComparator implements Comparator<Apple> {
        public int compare(Apple a1, Apple a2) {
            return a1.getWeight().compareTo(a2.getWeight());
        }
    }

    public static void sortAppleBasicStyle(List<Apple> inventory) {
        inventory.sort(new AppleComparator());
    }

    public static void sortAppleAnonymousClass(List<Apple> inventory) {
        inventory.sort(new Comparator<Apple>() {
            @Override
            public int compare(Apple o1, Apple o2) {
                return o1.getWeight().compareTo(o2.getWeight());
            }
        });
    }

    public static void sortAppleLambdaWithoutTypeReference(List<Apple> inventory) {
        inventory.sort((Apple a1, Apple a2) -> a1.getWeight().compareTo(a2.getWeight()));
    }

    public static void sortAppleLambdaWithTypeReference(List<Apple> inventory) {
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
    }

    public static void sortAppleLambdaWithComparing(List<Apple> inventory) {
        inventory.sort(comparing((a) -> a.getWeight()));
    }

    public static void sortAppleWithMethodReference(List<Apple> inventory) {
        inventory.sort(comparing(Apple::getWeight));
    }
}
