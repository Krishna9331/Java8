package java8.in.action.chapter3.lambda;

import common.vo.Apple;
import helper.AppleBuilder;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.List;

/**
 * Created by mishrk3 on 10/10/2015.
 */
public class ReferenceTest {

    private static List<Apple> apples;
    private static List<Apple> apples1;
    private static List<Apple> apples2;

    @BeforeClass
    public static void setUp(){
        apples = AppleBuilder.createApples();
        apples1 = AppleBuilder.createApples();
        apples2 = AppleBuilder.createApples();
    }

    @Test
    public void testSortAppleUsingComparing(){

        TypeReference.sortAppleUsingComparing(apples);
        Double weight = apples.get(0).getWeight();
        testSort(weight, apples);
    }

    @Test
    public void testSortAppleUsingMethodReference(){

        MethodReference.sortAppleUsingMethodReference(apples1);
        Double weight = apples1.get(0).getWeight();
        testSort(weight, apples1);
    }

    @Test
    public void testSortAppleUsingTypeReference(){

        TypeReference.sortAppleUsingTypeReference(apples2);
        Double weight = apples2.get(0).getWeight();
        testSort(weight, apples2);
    }

    private void testSort(Double weight, List<Apple> apples) {
        for(Apple apple : apples){
            Assert.assertTrue(weight <= apple.getWeight());
            weight = apple.getWeight();
        }
    }
}
