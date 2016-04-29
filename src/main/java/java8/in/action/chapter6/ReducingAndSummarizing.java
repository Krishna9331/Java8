package java8.in.action.chapter6;

import common.vo.Transaction;

import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.minBy;
import static java.util.stream.Collectors.reducing;
import static java.util.stream.Collectors.summarizingInt;
import static java.util.stream.Collectors.summingInt;

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

	/**
	 * @param transactions List of transactions
	 * @return sum of all the transactions happened
	 */
	public int totalTransaction(List<Transaction> transactions) {
		return transactions.stream().collect(summingInt(Transaction::getTradeAmount));
	}

	/**
	 * @param transactions list of transactions
	 * @return all the possible statistics sum, average, min, max, count together
	 * Along with int there are corresponding summarizingLong and summarizingDouble factory methods
	 * with associated types LongSummaryStatistics and DoubleSummaryStatistics; these are used
	 * when the property to be collected is a primitive-type long or a double.
	 */
	public IntSummaryStatistics getAllTogether(List<Transaction> transactions) {
		return transactions.stream().collect(summarizingInt(Transaction::getTradeAmount));
	}

	/**
	 * @param transactions list of transactions
	 * @return concatenated String of all the trader name involved in transactions
	 * joining invokes toString method on each object passed. It internally makes use of a StringBuilder to append the
	 * generated strings into one.
	 * So if Transaction class has toString method defined which returns just trader name we don't have to use map.
	 * {@code
	 * transactions.stream.collect(joining())
	 * }
	 * would have done the work.
	 * The overloaded version of joining accept the delimiter to separate the each object.
	 */
	public String joinTradersInTrans(List<Transaction> transactions) {
		return transactions.stream()
				.map(transaction -> transaction.getTrader().getName() + "-->" + transaction.getTradeYear() + "-->"
						+ transaction.getTradeAmount()).collect(joining(", "));
	}

	/**
	 * @param transactions list of transaction
	 * @return sum of all the transaction amount.
	 * In below case we have used the generalized reducing method of Collectors.
	 * It takes three argument
	 * 1) starting value() in case of addition)
	 * 2)the property on which we have to apply reduction(tradeAmount)
	 * 3)operation as lambda
	 */
	public int sumUsingReducingCollect(List<Transaction> transactions) {
		return transactions.stream().collect(reducing(0, Transaction::getTradeAmount, (i, j) -> i + j));
	}

	/**
	 * @param transactions list of transaction
	 * @return optional container having transaction with maximum trade amount
	 * collector created with the one-argument reducing factory method as a
	 * particular case of the three-argument method, which uses the first item in the stream as a
	 * starting point and an identity function (that is, a function doing nothing more than returning its
	 * input argument as is) as a transformation function.
	 */
	public Optional<Transaction> maxUsingReducingCollect(List<Transaction> transactions) {
		return transactions.stream().collect(reducing((t1, t2) -> t1.getTradeAmount() > t2.getTradeAmount() ? t1 :
				t2));
	}

}
