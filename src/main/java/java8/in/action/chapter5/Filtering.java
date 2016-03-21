package java8.in.action.chapter5;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mishrk3 on 3/8/2016.
 */
public class Filtering {

    /**
     * Stream API provides by default the filter method which takes a predicate and return the elements satisfying the
     * predicate condition.
     *
     * @param numbers takes the list of Integer
     * @return list of even Integer
     */
    public List<Integer> filterEvenInteger(List<Integer> numbers) {
        return numbers.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
    }

    /**
     * The stream Api also provides a method which removes the duplicate element
     *
     * @param numbers list of integers
     * @return list of distinct even integer
     */
    public List<Integer> filterDistinctEvenInteger(List<Integer> numbers) {
        return numbers.stream().filter(i -> i % 2 == 0).distinct().collect(Collectors.toList());
    }
}
