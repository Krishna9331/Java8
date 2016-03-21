package java8.in.action.chapter5;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by mishrk3 on 3/21/2016.
 */
public class FindingTest {

    private Finding finding;

    @Before
    public void setUp() {
        finding = new Finding();
    }

    @Test
    public void testFindAnyEvenNumber() {
        List<Integer> numbers = Arrays.asList(1, 4, 6, 8);
        Optional<Integer> result = finding.findAnyEvenNumber(numbers);
        assertTrue(result.isPresent());
    }

    @Test
    public void testFindAnyEvenNumberIfNotPresent() {
        List<Integer> numbers = Arrays.asList(1, 3, 7, 9);
        Optional<Integer> result = finding.findAnyEvenNumber(numbers);
        assertFalse(result.isPresent());
    }

    @Test
    public void testFindFirstEvenNumber() {
        List<Integer> numbers = Arrays.asList(1, 4, 6, 8);
        Optional<Integer> result = finding.findAnyEvenNumber(numbers);
        assertTrue(result.isPresent());
        assertTrue(result.get() == 4);
    }

    @Test
    public void testFindFirstEvenNumberIfNotPresent() {
        List<Integer> numbers = Arrays.asList(1, 3, 7, 9);
        Optional<Integer> result = finding.findAnyEvenNumber(numbers);
        assertFalse(result.isPresent());
    }
}
