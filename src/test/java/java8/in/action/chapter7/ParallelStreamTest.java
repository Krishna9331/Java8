package java8.in.action.chapter7;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mishrk3 on 5/6/2016.
 */
public class ParallelStreamTest {
	ParallelStream pStream = new ParallelStream();

	@Test public void testSumAll() {
		assertEquals(15, pStream.sumAll(5L).intValue());
	}

	@Test public void testSumAllUsingPrimitiveStream() {
		assertEquals(15, pStream.sumAllUsingPrimitiveStream(5L).intValue());
	}
}
