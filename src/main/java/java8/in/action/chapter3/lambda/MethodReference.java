package java8.in.action.chapter3.lambda;

import com.oracle.java8.vo.Apple;

import static java.util.Comparator.comparing;
import java.util.List;

/**
 * Created by mishrk3 on 10/10/2015.
 */
public class MethodReference {

    public static void sortAppleUsingMethodReference(List<Apple> inventory){
        inventory.sort(comparing(Apple :: getWeight));
    }
}
