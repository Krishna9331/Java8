package java8.in.action.chapter6;

import common.vo.Transaction;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.partitioningBy;

/**
 * Created by mishrk3 on 5/2/2016.<br/>
 * <br/>
 * Partitioning is a special case of grouping: having a predicate (a function returning a boolean),
 * called a partitioning function, as a classification function. The fact that the partitioning function
 * returns a boolean means the resulting grouping Map will have a Boolean as a key type and
 * therefore there can be at most two different groups—one for true and one for false.
 */
public class Partitioning {

	/**
	 * @param transactions list of transactions
	 * @return A map containing list of transaction which is passing the predicate and which fails
	 * <br/>
	 * We could have achieved the same by first applying the filter and then collect it as list.
	 * However the main difference is the for getting both the list of passing predicate and failing one
	 * we had to do two operation, but partitioningBy does this in one call for us.
	 */
	public Map<Boolean, List<Transaction>> transactionMoreThan100(List<Transaction> transactions) {
		return transactions.stream().collect(partitioningBy(t -> t.getTradeAmount() > 1000));
	}

	/**
	 * @param transactions list of transaction
	 * @return maximum amount of transaction in each group(grouping done on basis of more then 1000 or less).
	 */
	public Map<Boolean, Transaction> maxTransMorePerGrp(List<Transaction> transactions) {
		return transactions.stream().collect(partitioningBy(t -> t.getTradeAmount() > 1000,
				collectingAndThen(maxBy(Comparator.comparingInt(Transaction::getTradeAmount)), Optional::get)));
	}

	/**
	 * @param transactions list of transaction
	 * @return maximum amount of transaction in each group(grouping done on basis of more then 1000 or less).
	 */
	public Map<Boolean, Long> numberOfTransMorePerGrp(List<Transaction> transactions) {
		return transactions.stream().collect(partitioningBy(t -> t.getTradeAmount() > 1000, counting()));
	}

	public Map<Boolean, List<Integer>> firstNPrime(int n) {
		return IntStream.rangeClosed(2, n).boxed().collect(partitioningBy(i -> isPrime(i)));
	}

	private boolean isPrime(int num) {
		int root = (int) Math.sqrt((double) num);
		return IntStream.rangeClosed(2, root).noneMatch(i -> num % i == 0);
	}
}
