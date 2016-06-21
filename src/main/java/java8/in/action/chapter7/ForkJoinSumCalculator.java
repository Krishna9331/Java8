package java8.in.action.chapter7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * Created by mishrk3 on 6/1/2016.
 */

/**
 * The class is extending RecursiveTask for creating a task usable in fork join framework.
 * <br/>
 * Invoking the join method on a task blocks the caller until the result produced by that task is ready.
 * For this reason, it’s necessary to call it after the computation of both subtasks has been started.
 * Otherwise, you’ll end up with a slower and more complex version of your original sequential algorithm
 * because every subtask will have to wait for the other one to complete before starting.
 * <br/>
 * We must choose the criteria used to
 * decide if a given subtask should be further split or is small enough to be evaluated sequentially.
 * <br/>
 * #WorkStealing#
 * The fork/join framework works around this problem with a technique called work stealing. In
 * practice, this means that the tasks are more or less evenly divided on all the threads in the
 * ForkJoinPool. Each of these threads holds a doubly linked queue of the tasks assigned to it, and
 * as soon as it completes a task it pulls another one from the head of the queue and starts
 * executing it. For the reasons we listed previously, one thread might complete all the tasks
 * assigned to it much faster than the others, which means its queue will become empty while the
 * other threads are still pretty busy. In this case, instead of becoming idle, the thread randomly
 * chooses a queue of a different thread and “steals” a task, taking it from the tail of the queue. This
 * process continues until all the tasks are executed, and then all the queues become empty. That’s
 * why having many smaller tasks, instead of only a few bigger ones, can help in better balancing
 * the workload among the worker threads.
 */
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

	private final long[] numbers;
	private final int start;
	private final int end;
	/**
	 * The size of array for which the task should be computed sequentially.
	 */
	private static final long THRESHOLD = 10000;

	/**
	 * @param numbers array of numbers
	 *                The constructor used to create the task.
	 */
	public ForkJoinSumCalculator(long[] numbers) {
		this(numbers, 0, numbers.length);
	}

	private ForkJoinSumCalculator(long[] numbers, int start, int end) {
		this.numbers = numbers;
		this.start = start;
		this.end = end;
	}

	/**
	 * @return the sum of all entry in array.
	 * The compute operation is overridden method which does the actual operation.
	 */
	@Override protected Long compute() {
		int length = end - start;
		if (length <= THRESHOLD) {
			return computeSequentially();
		}
		//subtask to calculate first half
		ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
		//Asynchronously execute the newly created task subtask in another thread of ForkJoinPool
		leftTask.fork();

		//subtask for the second half
		ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
		//execute the second subtask synchronously, which further allow recursive splits.
		long rightResult = rightTask.compute();
		//read the result of first subtask or wait for it until it is not done
		long leftResult = leftTask.join();
		return rightResult + leftResult;
	}

	private long computeSequentially() {
		long sum = 0;
		for (int i = start; i < end; i++) {
			sum += numbers[i];
		}
		return sum;
	}

	/**
	 * @param n the number for which we are calculation sum of 0 to n.
	 * @return result of summation.
	 * <br/>
	 * Here, we generate an array containing the first n natural numbers using a LongStream. Then
	 * we create a ForkJoinTask (the superclass of RecursiveTask), passing this array to the public
	 * constructor of the ForkJoinSumCalculator. Finally, we create a new ForkJoinPool and pass that task to its
	 * invoke method. The value returned by this last method is the result of the task defined by the
	 * Fork-JoinSumCalculator class when executed inside the ForkJoinPool.
	 * <br/>
	 * When we pass the ForkJoinSumCalculator task to the ForkJoinPool, this task is executed by a
	 * thread of the pool that in turn calls the compute method of the task.
	 */
	public static long forkJoinSum(long n) {
		long[] numbers = LongStream.rangeClosed(1, n).toArray();
		ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
		return new ForkJoinPool().invoke(task);
	}
}
