package java8.in.action.chapter6;

import java8.in.action.chapter6.collector.CustomCollect;
import org.junit.Test;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by mishrk3 on 5/2/2016.
 */
public class CustomCollectorTest {

	CustomCollect cc = new CustomCollect();

	@Test public void testPartitionPrimesWithCustomCollector() {
		Map<Boolean, List<Integer>> result = cc.partitionPrimesWithCustomCollector(10);
		assertEquals(4, result.get(Boolean.TRUE));
	}
}
