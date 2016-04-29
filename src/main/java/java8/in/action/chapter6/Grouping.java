package java8.in.action.chapter6;

import common.vo.Transaction;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.summingInt;
import static java.util.stream.Collectors.toCollection;

/**
 * Created by mishrk3 on 4/29/2016.
 */
public class Grouping {

	/**
	 * @param transactions list of transactions
	 * @return Map of TransactionPeriod Vs List of Transaction on basis of transaction period
	 * The groupingBy collector lazily adds a new key in the grouping Map only the first time it finds an
	 * element in the stream, producing that key when applying on it the grouping criteria being used.
	 * So even return type of Collector is Optional the groupBy operation will not make any entry like
	 * Optional.empty for a key.
	 */
	public Map<TransactionPeriod, List<Transaction>> transactionByPeriod(List<Transaction> transactions) {
		return transactions.stream().collect(groupingBy(trans -> {
			return getTransactionPeriod(trans);
		}));
	}

	/**
	 * The below example is of multi level grouping. The groupingBy takes second argument as Collector
	 * where we can pass any Collector method or groupingBy itself.
	 *
	 * @param transactions list of transaction
	 * @return transaction group by period and then grouped by traders
	 */
	public Map<String, Map<TransactionPeriod, List<Transaction>>> groupByTraderAndPeriod(
			List<Transaction> transactions) {
		return transactions.stream().collect(
				groupingBy(tran -> tran.getTrader().getName(), groupingBy(trans -> getTransactionPeriod(trans))));

	}

	/**
	 * @param transactions list of transactions
	 * @return total transaction amount per user
	 */
	public Map<String, Integer> perUserTotalTransactionAmount(List<Transaction> transactions) {
		return transactions.stream()
				.collect(groupingBy(tran -> tran.getTrader().getName(), summingInt(Transaction::getTradeAmount)));
	}

	/**
	 * @param transactions list of transactions
	 * @return total transaction per user
	 */
	public Map<String, Long> perUserTotalTransaction(List<Transaction> transactions) {
		return transactions.stream().collect(groupingBy(tran -> tran.getTrader().getName(), counting()));
	}

	/**
	 * @param transactions list of transactions
	 * @return Maximum transaction per user
	 * Because the Optionals wrapping all the values in the Map resulting from the last grouping
	 * operation aren’t very useful in this case, you may want to get rid of them. To achieve this, or
	 * more generally, to adapt the result returned by a collector to a different type, you could use the
	 * collector returned by the Collectors.collectingAndThen factory method.<br/>
	 * <br/>
	 * This factory method takes two arguments, the collector to be adapted and a transformation
	 * function, and returns another collector. This additional collector acts as a wrapper for the old
	 * one and maps the value it returns using the transformation function as the last step of the collect
	 * operation.In this case, the wrapped collector is the one created with maxBy, and the
	 * transformation function, Optional::get, extracts the value contained in the Optional returned.
	 */
	public Map<String, Transaction> perUserMaxTransactionAmount(List<Transaction> transactions) {
		return transactions.stream().collect(groupingBy(tran -> tran.getTrader().getName(),
				collectingAndThen(maxBy(Comparator.comparingInt(Transaction::getTradeAmount)), Optional::get)));
	}

	/**
	 * @param transactions list of transaction
	 * @return set of TransactionPeriod if user has done any transaction in that period, for each period
	 * mapping method takes two arguments: a function transforming the elements in a
	 * stream and a further collector accumulating the objects resulting from this transformation. Its
	 * purpose is to adapt a collector accepting elements of a given type to one working on objects of a
	 * different type, by applying a mapping function to each input element before accumulating them.
	 * <br/>
	 * Here toCollection method makes sure that generated collection is HashSet.
	 */
	public Map<String, Set<TransactionPeriod>> perUSerTransactionPeriods(List<Transaction> transactions) {
		return transactions.stream().collect(groupingBy(tran -> tran.getTrader().getName(),
				mapping(t -> getTransactionPeriod(t), toCollection(HashSet::new))));
	}

	private TransactionPeriod getTransactionPeriod(Transaction trans) {
		if (trans.getTradeYear() > 2010)
			return TransactionPeriod.RECENT;
		else if (trans.getTradeYear() > 2000)
			return TransactionPeriod.MID;
		else
			return TransactionPeriod.EARLIER;
	}
}
