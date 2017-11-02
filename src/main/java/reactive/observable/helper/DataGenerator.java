package reactive.observable.helper;

import java.util.ArrayList;
import java.util.List;

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

}
