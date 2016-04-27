package java8.in.action.chapter5;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

/**
 * Created by mishrk3 on 4/27/2016.
 */
public class StreamFromFunctionTest {
	private StreamFromFunction stf = new StreamFromFunction();

	@Test public void testGenerateFirstNEven() {
		assertEquals(Arrays.asList(0, 2, 4, 6), stf.generateFirstNEven(4));
	}

	@Test public void testFirstFinNSeries() {
		assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5), stf.firstFibNSeries(6));
	}

	@Test public void testGetNFibUsingGenerate() {
		assertEquals(Arrays.asList(0, 1, 1, 2, 3, 5), stf.getNFibUsingGenerate(6));
	}
}
