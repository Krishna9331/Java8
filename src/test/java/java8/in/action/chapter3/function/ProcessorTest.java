package java8.in.action.chapter3.function;

import static org.junit.Assert.*;
import helper.AppleBuilder;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.oracle.java8.vo.Apple;

public class ProcessorTest {
	
	private static List<Apple> apples;
	
	@BeforeClass
	public static void setUp(){
		apples = AppleBuilder.createApples();
	}

	@Test
	public void testProcess() {
		List<Double> weights = Processor.map(apples, (Apple a) -> a.getWeight());
		List<Double> weightVerList = new ArrayList<>(); 
		for(Apple a : apples){
			weightVerList.add(a.getWeight());
		}
		
		for(Double weight : weights){
			assertTrue(weightVerList.contains(weight));
		}
	}

}
