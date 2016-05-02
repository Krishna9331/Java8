package java8.in.action.chapter6.collector;

import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

/**
 * Created by mishrk3 on 5/2/2016.
 */

/**
 * @param <T> is the generic type of the items in the stream to be collected.
 * @param <A> is the type of the accumulator, the object on which the partial result will be accumulated during the
 *            collection process.
 * @param <R> is the type of the object (typically, but not always, the collection) resulting from the collect
 *            operation.
 */
public interface CollectorInterface<T, A, R> {

	/**
	 * The supplier method has to return a Supplier of an empty result—a parameterless function that
	 * when invoked creates an instance of an empty accumulator used during the collection process.
	 * e.g. for case of toList collector it will return new ArrayList<T>();
	 *
	 * @return for a collector returning the accumulator itself as result
	 */
	Supplier<A> supplier();

	/**
	 * The accumulator method returns the function that performs the reduction operation.
	 * e.g. For ToListCollector, this function merely has to add
	 * the current item to the list containing the already traversed ones:
	 * list.add(item);
	 *
	 * @return
	 */
	BiConsumer<A, T> accumulator();

	/**
	 * The finisher method has to return a function that’s invoked at the end of the accumulation
	 * process, after having completely traversed the stream, in order to transform the accumulator
	 * object into the final result of the whole collection operation.
	 * e.g. for case of toList collector it will perform identity operation Function.identity();
	 *
	 * @return
	 */
	Function<A, R> finisher();

	/**
	 * The combiner method, the last of the four methods that return a function used by the reduction
	 * operation, defines how the accumulators resulting from the reduction of different subparts of
	 * the stream are combined when the subparts are processed in parallel.
	 * e.h. for toList it will do list1.addAll(list2);
	 * <br/>
	 * parallel computing is often slower than sequential
	 * computing when the units of work being distributed are too small, and it’s pointless to generate many
	 * more parallel tasks than you have processing cores
	 *
	 * @return
	 */
	BinaryOperator<A> combiner();

	/**
	 * characteristics, returns an immutable set of Characteristics, defining the
	 * behavior of the collector—in particular providing hints about whether the stream can be reduced
	 * in parallel and which optimizations are valid when doing so. Characteristics is an enumeration
	 * containing three items:
	 * <br/>
	 * <br/>
	 * UNORDERED—The result of the reduction isn’t affected by the order in which the items in the
	 * stream are traversed and accumulated.
	 * <br/>
	 *  CONCURRENT—The accumulator function can be called concurrently from multiple threads, and
	 * then this collector can perform a parallel reduction of the stream. If the collector isn’t also flagged as
	 * UNORDERED, it can perform a parallel reduction only when it’s applied to an unordered data
	 * source.
	 * <br/>
	 *  IDENTITY_FINISH—This indicates the function returned by the finisher method is the identity
	 * one, and its application can be omitted. In this case, the accumulator object is directly used as the final
	 * result of the reduction process. This also implies that it’s safe to do an unchecked cast from the
	 * accumulator A to the result R.
	 *
	 * @return
	 */
	Set<Collector.Characteristics> characteristics();
}
