package java8.in.action.chapter5;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by mishrk3 on 3/8/2016.
 */
public class Skipping {
    /**
     *The skip function will return empty stream if the number of element is less than limit
     *
     * @param numbers list of integer
     * @return list of integers passing the predicate condition except first two
     */
    public List<Integer> skipTwoElement(List<Integer> numbers) {
        return numbers.stream().filter(i -> i % 5 == 0).skip(2).collect(Collectors.toList());
    }
}
