package java8.in.action.chapter6;

import common.vo.Trader;
import common.vo.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by mishrk3 on 4/28/2016.
 */
public class ReducingAndSummarizingTest {

	private ReducingAndSummarizing ras;
	private List<Transaction> transactions;

	@Before public void setUp() {
		ras = new ReducingAndSummarizing();
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "California");

		transactions = Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012,
						700),
				new Transaction(alan, 2012, 950));
	}

	@Test public void testTransactionsByYear() {
		Map<Integer, List<Transaction>> result = ras.transactionsByYear(transactions);
		assertNotNull(result);
		assertEquals(2, result.keySet().size());
		assertEquals(2, result.get(2011).size());
		assertEquals(4, result.get(2012).size());
	}

	@Test public void testNumberOfTransactions() {
		assertEquals(6, ras.numberOfTransactions(transactions));
	}

	@Test public void testGetMaxUsingCollector() {
		Optional<Transaction> transaction = ras.getMaxUsingCollector(transactions);
		assertNotNull(transaction);
		assertTrue(transaction.isPresent());
		assertEquals("Raoul", transaction.get().getTrader().getName());
		assertEquals(1000, transaction.get().getTradeAmount());
	}

	@Test public void testGetMinUsingCollector() {
		Optional<Transaction> transaction = ras.getMinUsingCollector(transactions);
		assertNotNull(transaction);
		assertTrue(transaction.isPresent());
		assertEquals("Brian", transaction.get().getTrader().getName());
		assertEquals(300, transaction.get().getTradeAmount());
	}

	@Test public void testTotalTransaction() {
		assertEquals(4060, ras.totalTransaction(transactions));
	}

	@Test public void testGetAllTogether() {
		IntSummaryStatistics iss = ras.getAllTogether(transactions);
		assertEquals(6, iss.getCount());
		assertEquals(4060, iss.getSum());
		assertEquals(1000, iss.getMax());
		assertEquals(300, iss.getMin());
		double d1 = 4060;
		double d2 = 6;
		assertEquals(d1 / d2, iss.getAverage());
	}

	@Test public void testJoinTradersInTrans() {
		assertEquals(
				"Brian-->2011-->300, Raoul-->2012-->1000, Raoul-->2011-->400, Mario-->2012-->710, Mario-->2012-->700, "
						+ "Alan-->2012-->950", ras.joinTradersInTrans(transactions));
	}

	@Test public void testSumUsingReducingCollect() {
		assertEquals(4060, ras.sumUsingReducingCollect(transactions));
	}

	@Test public void testMaxUsingReducingCollect() {
		assertEquals(1000, ras.maxUsingReducingCollect(transactions).get().getTradeAmount());
	}
}
