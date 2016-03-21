package java8.in.action.chapter5;

import java.util.List;

/**
 * Created by mishrk3 on 3/21/2016.
 */
public class Matching {

    /**
     * The anyMatch operation of stream API return true if there is an element in the stream
     * matching the given predicate
     *
     * @param numbers list of integer
     * @return true if list contains any even number
     */
    public boolean checkEvenInList(List<Integer> numbers) {
        return numbers.stream().anyMatch(i -> i % 2 == 0);
    }

    /**
     * The allMatch operation of stream API return true if all the elements in the stream
     * match the given predicate
     *
     * @param numbers list of integer
     * @return true if list contains only even number
     */
    public boolean checkEvenList(List<Integer> numbers) {
        return numbers.stream().allMatch(i -> i % 2 == 0);
    }

    /**
     * The noneMatch operation of stream API return true if none of the elements in the stream
     * match the given predicate
     *
     * @param numbers list of integer
     * @return true if list contains only odd number
     */
    public boolean checkOddList(List<Integer> numbers) {
        return numbers.stream().noneMatch(i -> i % 2 == 0);
    }
}
