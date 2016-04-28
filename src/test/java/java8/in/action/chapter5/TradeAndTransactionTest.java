package java8.in.action.chapter5;

import java8.in.action.chapter5.problem.TradeAndTransactions;
import common.vo.Trader;
import common.vo.Transaction;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mishrk3 on 4/27/2016.
 */
public class TradeAndTransactionTest {
	private List<Trader> traders = new ArrayList<>();
	private List<Transaction> transactions;
	private TradeAndTransactions tradeAndTransactions;

	@Before public void setUp() {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "California");
		traders.add(raoul);
		traders.add(mario);
		traders.add(alan);
		traders.add(brian);

		transactions = Arrays.asList(new Transaction(brian, 2011, 300), new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400), new Transaction(mario, 2012, 710), new Transaction(mario, 2012,
						700),
				new Transaction(alan, 2012, 950));

		tradeAndTransactions = new TradeAndTransactions();
	}

	@Test public void testGet2011Trans() {
		assertEquals(2, tradeAndTransactions.get2011Trans(transactions).size());
	}

	@Test public void testGetAllDistinctCity() {
		assertEquals(3, tradeAndTransactions.getAllDistinctCity(traders).size());
	}

	@Test public void testGetCambridgeTraders() {
		List<Trader> result = tradeAndTransactions.getCambridgeTraders(traders);
		assertEquals(2, result.size());
		assertTrue("Alan".equals(result.get(0).getName()));
		assertTrue("Raoul".equals(result.get(1).getName()));
	}

	@Test public void testGetTraderNamesAlphabetically() {
		assertTrue("AlanBrianMarioRaoul".equals(tradeAndTransactions.getTraderNamesAlphabetically(traders)));
	}

	@Test public void testIsMilanTraders() {
		assertTrue(tradeAndTransactions.isMilanTrader(traders));
	}

	@Test public void testGetAllCambridgeTransaction() {
		assertEquals(3, tradeAndTransactions.getAllCambridgeTransaction(transactions).size());
	}

	@Test public void testGetHighestValueTransaction() {
		assertEquals(1000, tradeAndTransactions.getHighestValueTransaction(transactions).getTradeAmount());
	}

	@Test public void testGetLowestValueTransaction() {
		assertEquals(300, tradeAndTransactions.getLowestValueTransaction(transactions).getTradeAmount());
	}

}
