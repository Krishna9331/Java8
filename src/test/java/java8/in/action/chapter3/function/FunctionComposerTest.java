package java8.in.action.chapter3.function;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by mishrk3 on 10/10/2015.
 */
public class FunctionComposerTest {

    private String text;
    private Integer value;

    @Before
    public void setUp() {
        text = "I am learning labda";
        value = 3;
    }

    @Test
    public void testAndThenFunction() {
        String result = FunctionComposer.andThenFunction(text);
        assertFalse(result.contains("labda"));
        assertTrue(result.contains("lambda"));
    }

    @Test
    public void testComposeFunction() {
        Integer result = FunctionComposer.composeFunction(value);
        assertTrue(7 == result);
    }

    @Test
    public void testAndThenArithmeticFunction() {
        Integer result = FunctionComposer.andThenArithmeticFunction(value);
        assertTrue(8 == result);
    }
}
