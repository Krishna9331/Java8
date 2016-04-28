package java8.in.action.chapter5;

import common.vo.Transaction;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by mishrk3 on 4/27/2016.
 */
public class SpecializedPrimitiveStream {

	/**
	 * The below method uses the primitive stream and that is the only reason we are able to call sum()
	 *
	 * @param transactions list of transactions
	 * @return total transactions
	 */
	public int getTotalTransaction(List<Transaction> transactions) {
		return transactions.stream().mapToInt(t -> t.getTradeAmount()).sum();
	}

	/**
	 * The below method uses the primitive stream max call but max() do not have default value unlike sum() does as 0.
	 * That is the reason it return primitive version of optional which is OptionalInt. to extract the actual value
	 * we are using orElse.
	 *
	 * @param transactions list of transactions
	 * @return maximum transactions
	 */
	public int maxTransaction(List<Transaction> transactions) {
		return transactions.stream().mapToInt(Transaction::getTradeAmount).max().orElse(1);
	}

	/**
	 * The call of boxed() is making the primitive IntStream back to Stream<Integer> which allowed us to applu
	 * collect() method on it
	 *
	 * @param startIndex start of the range
	 * @param end        last number of the range exclusive
	 * @return list of integer from start to end
	 */
	public List<Integer> rangeNum(int startIndex, int end) {
		return IntStream.range(startIndex, end).boxed().collect(Collectors.toList());
	}

	/**
	 * The call of boxed() is making the primitive IntStream back to Stream<Integer> which allowed us to applu
	 * collect() method on it
	 *
	 * @param startIndex start of the range
	 * @param end        last number of the range including
	 * @return list of integer from start to end
	 */
	public List<Integer> rangeNumClosed(int startIndex, int end) {
		return IntStream.rangeClosed(startIndex, end).boxed().collect(Collectors.toList());
	}

	public List<double[]> allPythagoreanTriple(int start, int end) {
		return IntStream.rangeClosed(start, end).boxed().flatMap(
				a -> IntStream.rangeClosed(a, end).mapToObj(b -> new double[] { a, b, Math.sqrt(a * a + b * b) })
						.filter(t -> t[2] % 1 == 0)).collect(Collectors.toList());
	}

}
