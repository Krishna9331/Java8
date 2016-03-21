package java8.in.action.chapter5;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mishrk3 on 3/21/2016.
 */
public class MappingTest {

    private Mapping mapping;

    @Before
    public void setup() {
        mapping = new Mapping();
    }

    @Test
    public void testMappingOverString() {
        List<String> words = Arrays.asList("Krishna", "Good", "Indian");
        List<Integer> lengths = mapping.mappingOverString(words);
        assertFalse(lengths.isEmpty());
        assertEquals(lengths.size(), 3);
        assertTrue(lengths.get(0) == 7);
        assertTrue(lengths.get(1) == 4);
        assertTrue(lengths.get(2) == 6);
    }

    @Test
    public void testFlatten() {
        List<Integer> firstList = Arrays.asList(1, 4, 6, 8);
        List<Integer> secondList = Arrays.asList(2, 5, 7, 9, 11);
        List<Integer> result = mapping.flatten(firstList, secondList);
        assertFalse(result.isEmpty());
        assertEquals(result.size(), 9);
        assertTrue(result.contains(11));
        assertTrue(result.contains(8));
        assertTrue(result.contains(5));
        assertTrue(!result.contains(3));
    }

    @Test
    public void testUniqueCharacterFromWord() {
        List<String> words = Arrays.asList("Good", "Zoo");
        List<String> result = mapping.uniqueCharacterFromWord(words);
        assertFalse(result.isEmpty());
        assertEquals(result.size(), 4);
        assertTrue(result.contains("G"));
        assertTrue(result.contains("o"));
        assertTrue(result.contains("d"));
        assertTrue(result.contains("Z"));
    }

    @Test
    public void testSquareNumbers() {
        List<Integer> firstList = Arrays.asList(1, 4, 6, 8);
        List<Integer> result = mapping.squareNumbers(firstList);
        assertFalse(result.isEmpty());
        assertEquals(result.size(), 4);
        assertTrue(result.contains(1));
        assertTrue(result.contains(16));
        assertTrue(result.contains(36));
        assertTrue(result.contains(64));
    }

    @Test
    public void testPair() {
        List<Integer> firstList = Arrays.asList(1, 2, 3);
        List<Integer> secondList = Arrays.asList(3, 4);
        List<int[]> result = mapping.pair(firstList, secondList);
        assertFalse(result.isEmpty());
        assertEquals(result.size(), 6);
        assertTrue(result.get(0)[0] == 1);
        assertTrue(result.get(0)[1] == 3);
        assertTrue(result.get(5)[0] == 3);
        assertTrue(result.get(5)[1] == 4);
    }

    @Test
    public void testFilteredPair() {
        List<Integer> firstList = Arrays.asList(1, 2, 3);
        List<Integer> secondList = Arrays.asList(3, 4);
        List<int[]> result = mapping.filteredPair(firstList, secondList, 3);
        assertFalse(result.isEmpty());
        assertEquals(result.size(), 2);
        assertTrue(result.get(0)[0] == 2);
        assertTrue(result.get(0)[1] == 4);
        assertTrue(result.get(1)[0] == 3);
        assertTrue(result.get(1)[1] == 3);
    }
}
