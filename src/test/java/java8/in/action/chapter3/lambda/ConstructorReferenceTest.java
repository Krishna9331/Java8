package java8.in.action.chapter3.lambda;

import com.oracle.java8.vo.Apple;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by mishrk3 on 10/10/2015.
 */
public class ConstructorReferenceTest {

    @Test
    public void testGetObjectUsingSupplier() {
        Apple apple = ConstructorReference.getObjectUsingSupplier();
        assertTrue(null != apple);
    }

    @Test
    public void testGetObjectUsingSupplierLambda() {
        Apple apple = ConstructorReference.getObjectUsingSupplierLambda();
        assertTrue(null != apple);
    }

    @Test
    public void testGetAppleObjectWithWeightUsingFunctionReference() {
        Apple apple = ConstructorReference.getAppleObjectWithWeightUsingFunctionReference(170.0);
        assertTrue(null != apple);
        assertTrue(170.0 == apple.getWeight());
    }

    @Test
    public void testGetAppleObjectWithWeightUsingFunctionLambda() {
        Apple apple = ConstructorReference.getAppleObjectWithWeightUsingFunctionLambda(170.0);
        assertTrue(null != apple);
        assertTrue(170.0 == apple.getWeight());
    }

    @Test
    public void testGetAppleWithNameAndWeightFunctionReference() {
        Apple apple = ConstructorReference.getAppleWithNameAndWeightFunctionReference(140.0, "red");
        assertTrue(null != apple);
        assertTrue(140.0 == apple.getWeight());
        assertTrue("red".equals(apple.getColor()));
    }

    @Test
    public void testGetAppleWithNameAndWeightFunctionLambda() {
        Apple apple = ConstructorReference.getAppleWithNameAndWeightFunctionLambda(180.0, "green");
        assertTrue(null != apple);
        assertTrue(180.0 == apple.getWeight());
        assertTrue("green".equals(apple.getColor()));
    }

    @Test
    public void testGenerateApplesWithWeight() {
        List<Double> weights = Arrays.asList(70.0, 180.0, 90.0, 100.0, 120.5);
        List<Apple> apples = ConstructorReference.generateApplesWithWeight(weights);
        assertTrue(null != apples);
        assertTrue(5 == apples.size());
        for (Apple apple : apples) {
            assertTrue(weights.contains(apple.getWeight()));
        }
    }


}
