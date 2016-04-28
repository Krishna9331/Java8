package java8.in.action.chapter6;

import common.vo.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;

/**
 * Created by mishrk3 on 4/28/2016.
 */

/**
 * Invoking the collect method on a stream triggers a reduction
 * operation (parameterized by a Collector) on the elements of the stream itself.
 */
public class ReducingAndSummarizing {

	/**
	 * @param transactions list of transactions
	 * @return Transactions grouped by year of transaction
	 */
	public Map<Integer, List<Transaction>> transactionsByYear(List<Transaction> transactions) {
		return transactions.stream().collect(groupingBy(Transaction::getTradeYear));
	}

	/**
	 * @param transactions list of transactions
	 * @return total number of transactions
	 * Applying counting() of Collectors is bit more different then doing so using direct count() provided by stream,
	 * but the counting collector can be especially useful when used in combination with other
	 * collectors.
	 */
	public long numberOfTransactions(List<Transaction> transactions) {
		return transactions.stream().collect(counting());
	}

	/**
	 * @param transactions list of transactions
	 * @return Optional container with Transaction with max amount
	 * The maxBy takes comparator as an argument on basis of which it does the comparison.
	 * Here Optional is return type as if there is no element in list it will return a valid object in place of null.
	 */
	public Optional<Transaction> getMaxUsingCollector(List<Transaction> transactions) {
		Comparator<Transaction> transactionComparator = Comparator.comparingInt(Transaction::getTradeAmount);
		return transactions.stream().collect(maxBy(transactionComparator));
	}

	/**
	 * @param transactions list of transactions
	 * @return Optional container with Transaction with min amount
	 * The minBy also takes comparator as an argument on basis of which it does the comparison.
	 * Here Optional is return type as if there is no element in list it will return a valid object in place of null.
	 */
	public Optional<Transaction> getMinUsingCollector(List<Transaction> transactions) {
		Comparator<Transaction> transactionComparator = Comparator.comparingInt(Transaction::getTradeAmount);
		return transactions.stream().collect(minBy(transactionComparator));
	}
}
