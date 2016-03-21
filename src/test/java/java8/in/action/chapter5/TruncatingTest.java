package java8.in.action.chapter5;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by mishrk3 on 3/8/2016.
 */
public class TruncatingTest {

    private List<Integer> numbers;
    private List<Integer> lessNumbers;
    private Truncating truncating;

    @Before
    public void setUp() {
        truncating = new Truncating();
        numbers = Arrays.asList(1, 3, 5, 7, 8);
        lessNumbers = Arrays.asList(1, 2, 5, 9);
    }

    @Test
    public void testTruncateToThreeElements() {
        List<Integer> result = truncating.truncateToThreeElements(numbers);
        assertTrue(result.size() == 3);
    }

    @Test
    public void testTruncateToThreeElementsWithLessElements() {
        List<Integer> result = truncating.truncateToThreeElements(lessNumbers);
        assertTrue(result.size() == 2);
    }

    @Test
    public void testTruncateToTwoElements(){
        List<Integer> result = truncating.truncateToTwoElements(numbers);
        assertTrue(result.size() == 2);
    }

    @Test
    public void testTruncateToTwoElementsWithLessElement(){
        List<Integer> result = truncating.truncateToTwoElements(lessNumbers);
        assertTrue(result.size() == 2);
    }
}
