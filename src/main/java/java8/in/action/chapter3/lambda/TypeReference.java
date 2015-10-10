package java8.in.action.chapter3.lambda;

import com.oracle.java8.vo.Apple;

import java.util.List;

import static java.util.Comparator.comparing;

/**
 * Created by mishrk3 on 10/10/2015.
 */
public class TypeReference {

    //look at the missing type in Lambda parameter
    public static void sortAppleUsingTypeReference(List<Apple> inventory){
        inventory.sort((a1, a2) -> a1.getWeight().compareTo(a2.getWeight()));
    }

    public static void sortAppleUsingComparing(List<Apple> inventory){
        inventory.sort(comparing(apple -> apple.getWeight()));
    }
}
