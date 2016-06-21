package java8.in.action.chapter7;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mishrk3 on 6/2/2016.
 */
public class ForkJoinSumCalculatorTest {

	@Test public void testForkJoinSum() {
		assertEquals(ParallelStream.sumAll(1000000L).longValue(), ForkJoinSumCalculator.forkJoinSum(1000000));
	}
}
