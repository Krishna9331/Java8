package java8.in.action.chapter3.consumer;

import helper.AppleBuilder;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.oracle.java8.vo.Apple;

public class ItemIteratorTest {
	
	private static List<Apple> apples;
	
	@BeforeClass
	public static void setUp(){
		apples = AppleBuilder.createApples();
	}
	
	@Test
	public void printApples(){
		ItemIterator.forEach(apples, (Apple a) -> System.out.println(a.getColor()));
	}

}
