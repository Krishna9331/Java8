package java8.in.action.chapter2.weight;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import helper.AppleBuilder;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.oracle.java8.vo.Apple;

/**
 *
 * @author mishrk3
 */
public class AppleFilterTest {
    private static List<Apple> apples;

    public AppleFilterTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        apples = AppleBuilder.createApples();
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testFilterRedHeavyApple(){
       AppleRedAndHeavyPredicate arahp = new AppleRedAndHeavyPredicate();
       List<Apple> reList = AppleFilter.filterApple(apples, arahp);
        assertFalse(reList.isEmpty());
        assertTrue(reList.size() == 2);
   }
    
   @Test
   public void testFilterGreenApple(){
	   AppleGreenColorPredicate gColorPredicate = new AppleGreenColorPredicate();
       List<Apple> reList = AppleFilter.filterApple(apples, gColorPredicate);
        assertFalse(reList.isEmpty());
        assertTrue(reList.size() == 2);
   }
   
   @Test
   public void testFilterHeavyWeightApple(){
	   AppleHeavyWeightPredicate weightPredicate = new AppleHeavyWeightPredicate();
       List<Apple> reList = AppleFilter.filterApple(apples, weightPredicate);
        assertFalse(reList.isEmpty());
        assertTrue(reList.size() == 4);
   }
}
