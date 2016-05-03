package java8.in.action.chapter7;

/**
 * Created by mishrk3 on 5/3/2016.
 */

import java.util.stream.Stream;

/**
 * A parallel stream is a stream that
 * splits its elements into multiple chunks, processing each chunk with a different thread. Thus,
 * you can automatically partition the workload of a given operation on all the cores of your
 * multicore processor and keep all of them equally busy.
 * Parallel streams internally use the default ForkJoinPool which by default has as many threads as you have
 * processors, as returned by Runtime.getRuntime().availableProcessors().
 * java.util.concurrent.ForkJoinPool.common.parallelism is the system property which takes care of the thread pool.
 * However we can customize it by setting the system property e.g.
 * {@code System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "12");}
 * The above setting is global hence it will affect all the parallel stream operations.
 */
public class ParallelStream {

	/**
	 * The difference is that the Stream is internally divided into multiple chunks.
	 * As a result, the reduction operation can work on the various chunks independently and in parallel.
	 * Finally, the same reduction operation combines the values resulting from the partial reductions of each
	 * substream, producing the result of the reduction process on the whole initial stream.
	 * In reality, calling the method parallel on a sequential stream doesn’t imply any
	 * concrete transformation on the stream itself. Internally, a boolean flag is set to signal that we
	 * want to run in parallel all the operations that follow the invocation to parallel. Similarly, we can
	 * turn a parallel stream into a sequential one by just invoking the method sequential on it.
	 * While applying multiple parallel and sequential always the last call wins e.g.
	 * {@code
	 * stream.parallel()
	 * .filter(...)
	 * .sequential()
	 * .map(...)
	 * .parallel()
	 * .reduce();
	 * }
	 * on above code the pipeline will be executed in parallel because that’s the last call in the pipeline.
	 * However, applying parallel in the iterate process will be very slow: the iterate operation is hard
	 * to split into chunks that can be executed independently because the input of one function
	 * application always depends on the result of the previous application.
	 * The whole list of numbers isn’t available at the beginning of the reduction process, making it
	 * impossible to efficiently partition the stream in chunks to be processed in parallel. By flagging
	 * the stream as parallel, we’re just adding to the sequential processing the overhead of allocating
	 * each sum operation on a different thread. Also iterate generates boxed objects, which have to be unboxed to
	 * numbers before they can be added.
	 * LongStream.rangeClosed would be the better candidate for parallel stream.
	 * This is evidence that choosing the right data structures is often more important than parallelizing the
	 * algorithm that uses them.
	 *
	 * @param n the number till where we have to sum
	 * @return the result of addition
	 */
	public Long sumAll(int n) {
		return Stream.iterate(1L, i -> i + i + 1).limit(n).parallel().reduce(0L, Long::sum);
	}
}
