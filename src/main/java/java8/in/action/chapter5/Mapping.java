package java8.in.action.chapter5;

/**
 * Created by mishrk3 on 3/8/2016.
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Mapping in stream is done using two most popular method map and flatMap.
 */
public class Mapping {


    /**
     * Streams support the method map, which takes a function as argument. The function is applied
     * to each element, mapping it into a new element (the word mapping is used because it has a
     * meaning similar to transforming but with the nuance of “creating a new version of” rather than
     * “modifying”)
     *
     * @param words list of String
     * @return List of integers containing length of each word in the passed list
     */
    public List<Integer> mappingOverString(List<String> words) {
        return words.stream().map(word -> word.length()).collect(Collectors.toList());
    }

    /**
     * @param firstList  list of integer
     * @param secondList list of integer
     * @return combined list of integers with the elements of both the list
     */
    public List<Integer> flatten(List<Integer> firstList, List<Integer> secondList) {
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(firstList);
        lists.add(secondList);
        return lists.stream().flatMap(li -> li.stream().map(i -> i)).collect(Collectors.toList());
    }


    /**
     * The use of flatMap is really interesting below, lets think doing same using map operation.
     * after applying split we will get List of String array for each word with character of the word as entry of array.
     * so ["Hello", "World"] will become: ["H", "e", "l", "l", "o"] and ["W", "o", "r", "l", "d"] and then if we apply
     * distinct to get different character it will apply distinct on array rather than character(as String) in array.
     * Even after applying Array::Stream we will end up having Stream<Stream<String>>.
     * <p>
     * on the below flatMap operation flatten Stream<Stream<String>> into Stream<String> and then applying distinct
     * works fine.
     *
     * @param words List with String
     * @return a list of all the unique characters for a list of words
     */
    public List<String> uniqueCharacterFromWord(List<String> words) {
        return words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .collect(Collectors.toList());
    }

    /**
     * @param numbers List of integers
     * @return List of integers with square of each integer
     */
    public List<Integer> squareNumbers(List<Integer> numbers) {
        return numbers.stream().map(num -> num * num).collect(Collectors.toList());
    }


    /**
     * @param number1 list of integer
     * @param number2 list of integer
     * @return a list of integer array, where each array is pair of combination of elements of number1 and number2.
     */
    public List<int[]> pair(List<Integer> number1, List<Integer> number2) {
        return number1.stream().flatMap(i -> number2.stream().map(j -> new int[]{i, j})).collect(Collectors.toList());
    }

    /**
     * @param number1 list of integer
     * @param number2 list of integer
     * @param divisor number to which pair should be divisible
     * @return a list of integer array, where each array is pair of combination of elements of number1 and number2 and
     * sum of each pair is divisible by divisor
     */

    public List<int[]> filteredPair(List<Integer> number1, List<Integer> number2, int divisor) {
        return number1.stream().flatMap(i -> number2.stream()
                .filter(j -> (i + j) % divisor == 0)
                .map(j -> new int[]{i, j})).collect(Collectors.toList());

    }
}
