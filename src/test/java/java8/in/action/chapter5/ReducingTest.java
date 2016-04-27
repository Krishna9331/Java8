package java8.in.action.chapter5;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by mishrk3 on 4/27/2016.
 */
public class ReducingTest {

    private List<Integer> numbers;
    private Reducing reducing;

    @Before
    public void setUp() {
        reducing = new Reducing();
        numbers = Arrays.asList(2, 3, 5, 4);
    }

    @Test
    public void testAddElements() {
        assertEquals(14, reducing.addElements(numbers));
    }

    @Test
    public void testMultiplyElements() {
        assertEquals(120, reducing.multiplyElements(numbers));
    }

    @Test
    public void testMaxElements() {
        assertEquals(5, reducing.maxElement(numbers));
    }

    @Test
    public void testMinElements() {
        assertEquals(2, reducing.minElement(numbers));
    }

    @Test
    public void testCountElements() {
        assertEquals(4, reducing.countElement(numbers));
    }
}
