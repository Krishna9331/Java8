package java8.in.action.chapter6;

import common.vo.Trader;
import common.vo.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by mishrk3 on 5/2/2016.
 */
public class PartitioningTest {

	private List<Transaction> transactions;
	private Partitioning prt;

	@Before public void setUp() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "California");

		transactions = Arrays.asList(new Transaction(brian, 1909, 1300), new Transaction(raoul, 2005, 1000),
				new Transaction(raoul, 2001, 400), new Transaction(mario, 2012, 1710),
				new Transaction(mario, 2011, 700), new Transaction(raoul, 1980, 4000),
				new Transaction(mario, 2012, 1600), new Transaction(alan, 2007, 950));
		prt = new Partitioning();
	}

	@Test public void testTransactionMoreThan100() {
		Map<Boolean, List<Transaction>> trans = prt.transactionMoreThan100(transactions);
		assertEquals(4, trans.get(Boolean.TRUE).size());
		assertEquals(4, trans.get(Boolean.FALSE).size());
	}

	@Test public void testMaxTransMorePerGrp() {
		Map<Boolean, Transaction> trans = prt.maxTransMorePerGrp(transactions);
		assertEquals(4000, trans.get(Boolean.TRUE).getTradeAmount());
		assertEquals(1000, trans.get(Boolean.FALSE).getTradeAmount());
	}

	@Test public void testNumberOfTransMorePerGrp() {
		Map<Boolean, Long> trans = prt.numberOfTransMorePerGrp(transactions);
		assertEquals(4, trans.get(Boolean.TRUE).intValue());
		assertEquals(4, trans.get(Boolean.FALSE).intValue());
	}

	@Test public void testFirstNPrime() {
		Map<Boolean, List<Integer>> result = prt.firstNPrime(10);
		assertEquals(4, result.get(Boolean.TRUE).size());
	}
}
