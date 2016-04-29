package java8.in.action.chapter6;

import common.vo.Trader;
import common.vo.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java8.in.action.chapter6.TransactionPeriod.EARLIER;
import static java8.in.action.chapter6.TransactionPeriod.MID;
import static java8.in.action.chapter6.TransactionPeriod.RECENT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mishrk3 on 4/29/2016.
 */
public class GroupingTest {

	private List<Transaction> transactions;
	private Grouping grp;

	@Before public void setUp() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "California");

		transactions = Arrays.asList(new Transaction(brian, 1909, 300), new Transaction(raoul, 2005, 1000),
				new Transaction(raoul, 2001, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2011,
						700),
				new Transaction(raoul, 1980, 4000), new Transaction(mario, 2012, 600),
				new Transaction(alan, 2007, 950));
		grp = new Grouping();
	}

	@Test public void testTransactionByPeriod() {
		Map<TransactionPeriod, List<Transaction>> result = grp.transactionByPeriod(transactions);
		assertEquals(3, result.keySet().size());
		assertEquals(2, result.get(EARLIER).size());
		assertEquals(3, result.get(MID).size());
		assertEquals(3, result.get(RECENT).size());
	}

	@Test public void testGroupByTraderAndPeriod() {
		Map<String, Map<TransactionPeriod, List<Transaction>>> result = grp.groupByTraderAndPeriod(transactions);
		assertEquals(1, result.get("Brian").keySet().size());
		assertTrue(result.get("Brian").keySet().contains(EARLIER));

		assertEquals(2, result.get("Raoul").keySet().size());
		assertTrue(result.get("Raoul").keySet().contains(EARLIER));
		assertTrue(result.get("Raoul").keySet().contains(MID));
		assertEquals(2, result.get("Raoul").get(MID).size());

		assertEquals(3, result.get("Mario").get(RECENT).size());
	}

	@Test public void testPerUserTotalTransactionAmount() {
		Map<String, Integer> result = grp.perUserTotalTransactionAmount(transactions);
		assertEquals(300, result.get("Brian").intValue());
		assertEquals(5400, result.get("Raoul").intValue());
		assertEquals(950, result.get("Alan").intValue());
		assertEquals(2010, result.get("Mario").intValue());
	}

	@Test public void testPerUserTotalTransaction() {
		Map<String, Long> result = grp.perUserTotalTransaction(transactions);
		assertEquals(1, result.get("Brian").longValue());
		assertEquals(3, result.get("Raoul").longValue());
		assertEquals(1, result.get("Alan").longValue());
		assertEquals(3, result.get("Mario").longValue());
	}

	@Test public void testPerUserMaxTransactionAmount() {
		Map<String, Transaction> result = grp.perUserMaxTransactionAmount(transactions);
		assertEquals(300, result.get("Brian").getTradeAmount());
		assertEquals(4000, result.get("Raoul").getTradeAmount());
		assertEquals(950, result.get("Alan").getTradeAmount());
		assertEquals(710, result.get("Mario").getTradeAmount());
	}

	@Test public void testPerUSerTransactionPeriods() {
		Map<String, Set<TransactionPeriod>> result = grp.perUSerTransactionPeriods(transactions);
		assertEquals(1, result.get("Brian").size());
		assertEquals(2, result.get("Raoul").size());
		assertEquals(1, result.get("Alan").size());
		assertEquals(1, result.get("Mario").size());
	}
}
