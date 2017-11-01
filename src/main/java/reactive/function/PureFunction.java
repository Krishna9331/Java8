package reactive.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class PureFunction {

    public boolean isSorted(List<Integer> integers, BiFunction<Integer, Integer, Boolean> method) {
        return  check(integers, 0, 1, method);
    }

    private boolean check(List<Integer> integers, int low, int high, BiFunction<Integer, Integer, Boolean> method) {
        boolean val = method.apply(integers.get(low), integers.get(high));
        if(!val) return false;
        else if(val && high < integers.size() -1) check(integers, high, high+1, method);
        return true;
    }


    public static void main(String[] args) {
        PureFunction pf = new PureFunction();
        List<Integer> l1 = Arrays.asList(2, 5, 7 ,9 , 13);
        List<Integer> l2 = Arrays.asList(7, 5, 3, 1);
        System.out.println("Arrays 1 is Ascending: " + pf.isSorted(l1, (x, y) -> x < y));
        System.out.println("Arrays 2 is Ascending: " + pf.isSorted(l2, (x, y) -> x < y));
        System.out.println("Arrays 1 is Descending: " + pf.isSorted(l1, (x, y) -> x > y));
        System.out.println("Arrays 2 is Descending: " + pf.isSorted(l2, (x, y) -> x > y));
    }
}
