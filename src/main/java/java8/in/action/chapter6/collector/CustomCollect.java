package java8.in.action.chapter6.collector;

/**
 * Created by mishrk3 on 5/2/2016.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.IntStream;

/**
 * In the case of an IDENTITY_FINISH collection operation, there’s a further possibility of
 * obtaining the same result without developing a completely new implementation of the Collector
 * interface. Stream has an overloaded collect method accepting the three other
 * functions—supplier, accumulator, and combiner—having exactly the same semantics as the ones
 * returned by the corresponding methods of the Collector interface.e.g.
 * <pre>
 * transactions.collect(ArrayList :: new,
 * 						List::add,
 * 						List ::addAll);
 * </pre>
 * One possible optimization for finding first n prime numbers is to test only if the candidate number is
 * divisible by prime numbers.
 * It’s pointless to test it against a divisor that’s not itself prime! So we can limit the test to only
 * the prime numbers found before the current candidate. The problem with the predefined
 * collectors we’ve used so far, and the reason we have to develop a custom one, is that during the
 * collecting process we don’t have access to the partial result. This means that when testing
 * whether a given candidate number is prime or not, we don’t have access to the list of the other
 * prime numbers found so far. Also, we should implement the same optimization we used before and test only with
 * primes smaller than the square root of the candidate number. So we need a way to stop testing whether
 * the candidate is divisible by a prime as soon as the next prime is greater than the candidate’s
 * root.
 */
public class CustomCollect {

	public static <A> List<A> takeWhile(List<A> list, Predicate<A> p) {
		int i = 0;

		for (A item : list) {
			if (!p.test(item)) {
				return list.subList(0, i);
			}
			i++;
		}
		return list;
	}

	public static boolean isPrime(List<Integer> primes, int num) {
		int root = (int) Math.sqrt((double) num);
		return takeWhile(primes, i -> i <= root).stream().noneMatch(p -> num % p == 0);
	}

	/**
	 * In this
	 * case, we want to collect streams of Integers while both the accumulator and the result types are
	 * Map<Boolean, List<Integer>>
	 */
	class PrimeNumberCollector implements Collector<Integer, Map<Boolean, List<Integer>>, Map<Boolean,
			List<Integer>>> {

		@Override public Supplier<Map<Boolean, List<Integer>>> supplier() {
			return () -> new HashMap<Boolean, List<Integer>>() {{
				put(true, new ArrayList<Integer>());
				put(false, new ArrayList<Integer>());
			}};
		}

		/**
		 * The most important method of your collector is the accumulator method, because it contains the logic
		 * defining how the elements of the stream have to be collected. In this case, it’s also the key to
		 * implementing the optimization for prime numbers.
		 *
		 * @return
		 */
		@Override public BiConsumer<Map<Boolean, List<Integer>>, Integer> accumulator() {
			return (Map<Boolean, List<Integer>> acc, Integer candidate) -> {
				acc.get(isPrime(acc.get(true), candidate)).add(candidate);
			};
		}

		@Override public BinaryOperator<Map<Boolean, List<Integer>>> combiner() {
			return (Map<Boolean, List<Integer>> map1, Map<Boolean, List<Integer>> map2) -> {
				map1.get(true).addAll(map2.get(true));
				map1.get(false).addAll(map2.get(false));
				return map1;
			};
		}

		@Override public Function<Map<Boolean, List<Integer>>, Map<Boolean, List<Integer>>> finisher() {
			return Function.identity();
		}

		@Override public Set<Characteristics> characteristics() {
			return Collections.unmodifiableSet(EnumSet.of(Characteristics.IDENTITY_FINISH));
		}
	}

	public Map<Boolean, List<Integer>> partitionPrimesWithCustomCollector(int n) {
		return IntStream.rangeClosed(2, n).boxed().collect(new PrimeNumberCollector());
	}
}
