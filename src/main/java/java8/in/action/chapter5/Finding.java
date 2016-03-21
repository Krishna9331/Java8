package java8.in.action.chapter5;

import java.util.List;
import java.util.Optional;

/**
 * Created by mishrk3 on 3/21/2016.
 */
public class Finding {

    /**
     * findAny method returns an arbitrary element of the current stream
     *
     * @param numbers list of number
     * @return any even number in list if present
     */
    public Optional<Integer> findAnyEvenNumber(List<Integer> numbers) {
        return numbers.stream().filter(i -> i % 2 == 0).findAny();
    }

    /**
     * findFirst method returns an first element of the current stream
     *
     * @param numbers list of number
     * @return any even number in list if present
     */
    public Optional<Integer> findFirstEvenNumber(List<Integer> numbers) {
        return numbers.stream().filter(i -> i % 2 == 0).findFirst();
    }
}
