package java8.in.action.chapter5;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mishrk3 on 3/8/2016.
 */
public class Truncating {

    /**
     *
     * @param numbers takes the list of integers
     * @return the first 3 integers from start which passed the predicate condition
     */
    public List<Integer> truncateToThreeElements(List<Integer> numbers) {
        return numbers.stream().filter(i -> i > 4).limit(3).collect(Collectors.toList());
    }

    /**
     *
     * @param numbers list f integer
     * @return the first 2 integers from start which passed the predicate condition
     */
    public List<Integer> truncateToTwoElements(List<Integer> numbers) {
        return numbers.stream().filter(i -> i > 4).limit(2).collect(Collectors.toList());
    }
}
