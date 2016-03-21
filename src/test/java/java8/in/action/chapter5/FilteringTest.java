package java8.in.action.chapter5;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by mishrk3 on 3/8/2016.
 */
public class FilteringTest {

    private List<Integer> numbers;
    private Filtering filtering;

    @Before
    public void setUp() {
        filtering = new Filtering();
        numbers = Arrays.asList(1, 2, 3, 4, 5, 2, 7, 9, 6);
    }

    @Test
    public void testFilterEvenInteger() {
        List<Integer> result = filtering.filterEvenInteger(numbers);
        assertEquals(result.size(), 4);
    }

    @Test
    public void testFilterDistinctEvenInteger() {
        List<Integer> result = filtering.filterDistinctEvenInteger(numbers);
        assertEquals(result.size(), 3);
    }
}
