package java8.in.action.chapter7;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by mishrk3 on 5/12/2016.
 */
public class PerformanceAnalysisTest {
	PerformanceAnalysis pa = null;
	ParallelStream ps = null;

	@Before public void setUp() {
		pa = new PerformanceAnalysis();
	}

	@Test public void testParallelPerformance() {
		Long result1 = pa.measureSumPerf(ParallelStream::sumAll, 10_000_000);
		Long result2 =pa.measureSumPerf(ParallelStream::sumAllUsingPrimitiveStream, 10_000_000);
		assertTrue(result1 > result2);
	}
}
