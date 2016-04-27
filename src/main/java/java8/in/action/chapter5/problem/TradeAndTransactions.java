package java8.in.action.chapter5.problem;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Comparator.comparing;

/**
 * Created by mishrk3 on 4/27/2016.
 */
public class TradeAndTransactions {

	public List<Transaction> get2011Trans(List<Transaction> transactions) {
		return transactions.stream().filter(transaction -> transaction.getTradeYear() == 2011)
				.collect(Collectors.toList());
	}

	public List<String> getAllDistinctCity(List<Trader> traders) {
		return traders.stream().map(trader -> trader.getPlace()).distinct().collect(Collectors.toList());
	}

	public List<Trader> getCambridgeTraders(List<Trader> traders) {
		return traders.stream().filter(trader -> "Cambridge".equals(trader.getPlace()))
				.sorted(comparing(Trader::getName)).collect(Collectors.toList());
	}

	public String getTraderNamesAlphabetically(List<Trader> traders) {
		return traders.stream().map(trader -> trader.getName()).sorted(String::compareTo)
				.reduce("", (name1, name2) -> name1 + name2);
	}

	public boolean isMilanTrader(List<Trader> traders) {
		return traders.stream().anyMatch(trader -> "Milan".equals(trader.getPlace()));
	}

	public List<Transaction> getAllCambridgeTransaction(List<Transaction> transactions) {
		return transactions.stream().filter(transaction -> "Cambridge".equals(transaction.getTrader().getPlace()))
				.collect(Collectors.toList());
	}

	public Transaction getHighestValueTransaction(List<Transaction> transactions) {
		return transactions.stream().reduce((t1, t2) -> t1.getTradeAmount() > t2.getTradeAmount() ? t1 : t2).get();
	}

	public Transaction getLowestValueTransaction(List<Transaction> transactions) {
		return transactions.stream().reduce((t1, t2) -> t1.getTradeAmount() > t2.getTradeAmount() ? t2 : t1).get();
	}
}
