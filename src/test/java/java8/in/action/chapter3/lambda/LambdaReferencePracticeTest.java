package java8.in.action.chapter3.lambda;

import common.vo.Apple;
import helper.AppleBuilder;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import java.util.List;

/**
 * Created by mishrk3 on 10/10/2015.
 */
public class LambdaReferencePracticeTest {

    private List<Apple> apples;

    @Before
    public void setUp() {
      apples = AppleBuilder.createApples();
    }

    @Test
    public void testSortAppleBasicStyle(){
        LambdaReferencePractice.sortAppleBasicStyle(apples);
        test(apples);
    }@Test
    public void testSortAppleAnonymousClass(){
        LambdaReferencePractice.sortAppleAnonymousClass(apples);
        test(apples);
    }@Test
    public void testSortAppleLambdaWithoutTypeReference(){
        LambdaReferencePractice.sortAppleLambdaWithoutTypeReference(apples);
        test(apples);
    }@Test
    public void testSortAppleLambdaWithTypeReference(){
        LambdaReferencePractice.sortAppleLambdaWithTypeReference(apples);
        test(apples);
    }

    @Test
    public void testSortAppleLambdaWithComparing(){
        LambdaReferencePractice.sortAppleLambdaWithComparing(apples);
        test(apples);
    }

    @Test
    public void testSortAppleWithMethodReference(){
        LambdaReferencePractice.sortAppleWithMethodReference(apples);
        test(apples);
    }

    private void test(List<Apple> apples) {
        Double weight = apples.get(0).getWeight();
        for(Apple apple : apples){
            assertTrue(weight <= apple.getWeight());
            weight = apple.getWeight();
        }
    }
}
