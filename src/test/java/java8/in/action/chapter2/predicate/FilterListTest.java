package java8.in.action.chapter2.predicate;

import static org.junit.Assert.*;
import helper.AppleBuilder;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.oracle.java8.vo.Apple;

public class FilterListTest {
	
	 private static List<Apple> apples;
		
	 @BeforeClass
	    public static void setUpClass() {
	        apples = AppleBuilder.createApples();
	    }

	@Test
	public void testFilter() {
		List<Apple> result = FilterList.filter(apples, (Apple apple) -> "red".equals(apple.getColor()));
		assertFalse(result.isEmpty());
		assertTrue(result.size() == 4);
	}

}
