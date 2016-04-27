package java8.in.action.chapter5;

import java.util.List;
import java.util.function.IntSupplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by mishrk3 on 4/27/2016.
 */
public class StreamFromFunction {

	/**
	 * iterate is one of the two methods for generating stream from function, However it always generate the infinite
	 * stream, hence use of limit is very important here
	 *
	 * @param n an integer
	 * @return list of first n even numbers
	 */
	public List<Integer> generateFirstNEven(int n) {
		return Stream.iterate(0, num -> num + 2).limit(n).collect(Collectors.toList());
	}

	public List<Integer> firstFibNSeries(int n) {
		return Stream.iterate(new int[] { 0, 1 }, t -> new int[] { t[1], t[0] + t[1] }).limit(n).map(t -> t[0])
				.collect(Collectors.toList());
	}

	/**
	 * generate doesn’t apply successively a function on each new
	 * produced value. It takes a lambda of type Supplier<T> to provide new values.
	 * However, to deal with previous value we can maintain states and then do the things as below:
	 * Similar to iterate generate also creates infinite stream hence use of limit is very important here as well.
	 *
	 * @param n an integer
	 * @return list of first n fibonacci number
	 * Using below code has lot's of risk while using parallel stream as it maintains state. In all the lambda
	 * functions we never maintain any states.
	 */
	public List<Integer> getNFibUsingGenerate(int n) {
		IntSupplier fibSupplier = new IntSupplier() {
			private int previous = 0;
			private int current = 1;

			@Override public int getAsInt() {
				int oldPrevious = this.previous;
				int nextValue = this.previous + this.current;
				this.previous = this.current;
				this.current = nextValue;
				return oldPrevious;
			}
		};
		return IntStream.generate(fibSupplier).limit(n).boxed().collect(Collectors.toList());
	}
}
