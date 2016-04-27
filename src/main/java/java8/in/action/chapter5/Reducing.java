package java8.in.action.chapter5;

/**
 * Created by mishrk3 on 3/31/2016.
 */

import java.util.List;
import java.util.Optional;

/**
 * In reduce the terminal operation produce the actual value. e.g: adding all element of list, or the highest value in
 * the list.
 * In functional programming language we call reduce as fold operation, because it continuously consume the element and
 * produce the single one OR repeatedly folding a long piece of paper (stream) until it forms a small square, which is
 * the result of the fold operation.
 */
public class Reducing {
    /**
     * The reduction operation takes the default value and a BinaryOperator<T> to combine two elements and produce a
     * new value; here we use the lambda (a, b) -> a + b.
     * The first call will look like(0, first element of list)
     *
     * @param integers list of integers
     * @return sum of all the elements of list
     */
    public int addElements(List<Integer> integers) {
        return integers.stream().reduce(0, (a, b) -> a + b);
    }

    /**
     * @param integers list of integers
     * @return multiplied result of all elements
     */
    public int multiplyElements(List<Integer> integers) {
        return integers.stream().reduce(1, (a, b) -> a * b);
    }

    /**
     * Since the reduce operation does not take any initial value so it returns the Optional here. If list has no
     * element then it will return Optional.empty
     *
     * @param integers list of integers
     * @return sum of all the elements of list inside the Optional container
     */
    public Optional<Integer> addWithoutDefault(List<Integer> integers) {
        return integers.stream().reduce(Integer::sum);
    }

    /**
     * @param integers list of integers
     * @return largest element of the list
     * The below lambdas return the maximum of the two elements
     */
    public int maxElement(List<Integer> integers) {
        return integers.stream().reduce(0, (a, b) -> a > b ? a : b);
    }

    /**
     * @param integers list of integers
     * @return smallest element of the list
     * The below lambdas return the maximum of the two elements
     */
    public int minElement(List<Integer> integers) {
        return integers.stream().reduce(0, (a, b) -> a > b ? b : a);
    }

    /**
     * @param integers list of integers
     * @return number of elements in the list
     * The below lambdas return the maximum of the two elements
     */
    public int countElement(List<Integer> integers) {
        return integers.stream().reduce(0, (a, b) -> a + 1);
    }
}
