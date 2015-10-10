package java8.in.action.chapter3.predicate;

import common.vo.Apple;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static java.util.Comparator.comparing;

/**
 * Created by mishrk3 on 10/10/2015.
 */
public class PredicateComposerComparator {

    public static void reverseSort(List<Apple> inventory) {
        inventory.sort(comparing(Apple::getWeight).reversed());
    }

    public static void chainingComparator(List<Apple> inventory) {
        inventory.sort(comparing(Apple::getWeight)
                .thenComparing(Apple::getOrigin));
    }

    public static List<Apple> negatePredicate(List<Apple> inventory) {
        Predicate<Apple> redApple = getRedApplePredicate();

        Predicate<Apple> notRed = redApple.negate();

        List<Apple> notRedApples = filter(inventory, notRed);
        return notRedApples;
    }

    private static Predicate<Apple> getRedApplePredicate() {
        return new Predicate<Apple>() {
            @Override
            public boolean test(Apple apple) {
                return "red".equals(apple.getColor());
            }
        };
    }

    private static List<Apple> filter(List<Apple> inventory, Predicate<Apple> notRed) {
        List<Apple> result = new ArrayList<Apple>();
        for (Apple apple : inventory) {
            if (notRed.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> redAndHeavyApple(List<Apple> inventory) {
        Predicate<Apple> redApple = getRedApplePredicate();
        Predicate<Apple> redAndHeavy = redApple.and(a -> a.getWeight() > 150);
        return filter(inventory, redAndHeavy);
    }

    public static List<Apple> redAndHeavyOrGreen(List<Apple> inventory) {
        Predicate<Apple> redApple = getRedApplePredicate();
        Predicate<Apple> redAndHeavyOrGreen = redApple.and(a -> a.getWeight() > 150)
                .or(a -> "green".equals(a.getColor()));
        return filter(inventory, redAndHeavyOrGreen);
    }
}
