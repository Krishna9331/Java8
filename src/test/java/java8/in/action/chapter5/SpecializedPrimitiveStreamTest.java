package java8.in.action.chapter5;

import common.vo.Trader;
import common.vo.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by mishrk3 on 4/27/2016.
 */
public class SpecializedPrimitiveStreamTest {
	private List<Transaction> transactions;
	private SpecializedPrimitiveStream stream;

	@Before public void setUp() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "California");

		transactions = Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012,
						700),
				new Transaction(alan, 2012, 950));

		stream = new SpecializedPrimitiveStream();
	}

	@Test public void testGetTotalTransaction() {
		assertEquals(4060, stream.getTotalTransaction(transactions));
	}

	@Test public void testMaxTransaction() {
		assertEquals(1000, stream.maxTransaction(transactions));
	}

	@Test public void testRangeNum() {
		assertEquals(9, stream.rangeNum(1, 10).size());
	}

	@Test public void testRangeNumClosed() {
		assertEquals(10, stream.rangeNumClosed(1, 10).size());
	}
	@Test public void testAllPythagoreanTriple() {
		assertEquals(7, stream.allPythagoreanTriple(1, 20).size());
	}
}
