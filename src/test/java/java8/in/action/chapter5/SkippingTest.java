package java8.in.action.chapter5;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by mishrk3 on 3/8/2016.
 */
public class SkippingTest {

    private Skipping skipping;
    private List<Integer> numbers;
    private List<Integer> numberList;

    @Before
    public void setUp() {
        skipping = new Skipping();
        numberList = Arrays.asList(5, 10, 9);
        numbers = Arrays.asList(1, 5, 15, 25);
    }

    @Test
    public void testSkipTwoElementWithLessNumbers() {
        List<Integer> result = skipping.skipTwoElement(numberList);
        assertTrue(result.isEmpty());
    }

    @Test
    public void testSkipTwoElement() {
        List<Integer> result = skipping.skipTwoElement(numbers);
        assertTrue(result.size() == 1);
    }
}
