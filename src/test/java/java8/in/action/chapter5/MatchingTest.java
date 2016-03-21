package java8.in.action.chapter5;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mishrk3 on 3/21/2016.
 */
public class MatchingTest {

    private Matching matching;

    @Before
    public void setUp() {
        matching = new Matching();
    }

    @Test
    public void testCheckEvenInList() {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 6, 9);
        assertTrue(matching.checkEvenInList(numbers));
    }

    @Test
    public void testCheckEvenInListIfNotPresent() {
        List<Integer> numbers = Arrays.asList(1, 3, 9);
        assertFalse(matching.checkEvenInList(numbers));
    }

    @Test
    public void testCheckEvenList() {
        List<Integer> numbers = Arrays.asList(2, 4, 8);
        assertTrue(matching.checkEvenList(numbers));
    }

    @Test
    public void testCheckEvenListWithOdd() {
        List<Integer> numbers = Arrays.asList(2, 4, 8, 9);
        assertFalse(matching.checkEvenList(numbers));
    }

    @Test
    public void testCheckOddList() {
        List<Integer> numbers = Arrays.asList(1, 3, 9);
        assertTrue(matching.checkOddList(numbers));
    }

    @Test
    public void testCheckOddListWithEven() {
        List<Integer> numbers = Arrays.asList(1, 3, 8, 9);
        assertFalse(matching.checkOddList(numbers));
    }
}
