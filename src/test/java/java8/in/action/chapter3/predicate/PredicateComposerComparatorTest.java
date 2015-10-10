package java8.in.action.chapter3.predicate;

import common.vo.Apple;
import helper.AppleBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by mishrk3 on 10/10/2015.
 */
public class PredicateComposerComparatorTest {

    private List<Apple> apples;

    @Before
    public void setUp() {
        apples = AppleBuilder.createApples();
    }

    @Test
    public void testReverseSort() {
        PredicateComposerComparator.reverseSort(apples);
        Double weight = apples.get(0).getWeight();
        for (Apple apple : apples) {
            assertTrue(weight >= apple.getWeight());
            weight = apple.getWeight();
        }
    }

    @Test
    public void testChainingComparator() {
        PredicateComposerComparator.chainingComparator(apples);
        Double weight = apples.get(0).getWeight();
        String origin = apples.get(0).getOrigin();
        for (Apple apple : apples) {
            assertTrue(weight <= apple.getWeight());
            if (weight == apple.getWeight()) {
                assertTrue(origin.compareTo(apple.getOrigin()) >= 0);
            }
            weight = apple.getWeight();
            origin = apple.getOrigin();
        }
    }

    @Test
    public void testNegatePredicate() {
        List<Apple> results = PredicateComposerComparator.negatePredicate(apples);
        for (Apple apple : results) {
            assertFalse("red".equals(apple.getColor()));
        }
    }

    @Test
    public void testRedAndHeavyApple() {
        List<Apple> result = PredicateComposerComparator.redAndHeavyApple(apples);
        for (Apple apple : result) {
            assertTrue("red".equals(apple.getColor()));
            assertTrue(apple.getWeight() >= 150);
        }
    }

    @Test
    public void testRedAndHeavyOrGreen() {
        List<Apple> result = PredicateComposerComparator.redAndHeavyOrGreen(apples);
        for (Apple apple : result) {
            if ("red".equals(apple.getColor())) {
                assertTrue(apple.getWeight() >= 150);
            } else {
                assertTrue("green".equals(apple.getColor()));
            }
        }
    }
}
