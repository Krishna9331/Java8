package reactive.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DataGenerator {

    public static Integer[] getFibonacciArray() {
        Integer[] arr = new Integer[7];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 5;
        arr[4] = 8;
        arr[5] = 13;
        arr[6] = 21;
        return arr;
    }

    public static List<Integer> getFibonacci() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.add(8);
        list.add(13);
        list.add(21);
        list.add(34);
        list.add(55);
        return list;
    }

    public static List<String> getGeekAlphabets() {
        List<String> list = new ArrayList<>();
        list.add("Alpha");
        list.add("Beta");
        list.add("Gamma");
        list.add("Delta");
        list.add("Epsilon");
        list.add("Zeta");
        list.add("Eta");
        list.add("Theta");
        list.add("Iota");
        list.add("Kappa");
        list.add("Lambda");
        list.add("Mu");
        list.add("Nu");
        list.add("Xi");
        list.add("Omicron");
        list.add("Pi");
        list.add("Rho");
        list.add("Sigma");
        list.add("Tau");
        list.add("Upsilon");
        list.add("Phi");
        list.add("Chi");
        list.add("Psi");
        list.add("Omega");
        return list;
    }

    public static List<String> getEmptyGeekAlphabets() {
        List<String> list = new ArrayList<>();
        return list;
    }

    public static List<String> generateScrambledAlphabet() {
        List<String> list = new ArrayList<>();
        list.addAll(getGeekAlphabets());
        list.addAll(getGeekAlphabets());
        list.addAll(getGeekAlphabets());
        Collections.shuffle(list);
        return list;
    }

    public static List<Integer> generateBigIntegers() {
        return IntStream.range(0, 100).boxed().collect(Collectors.toList());
    }
}
