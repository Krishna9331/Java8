package java8.in.action.chapter2.print;

import static org.junit.Assert.*;
import helper.AppleBuilder;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import com.oracle.java8.vo.Apple;

public class ApplePrinterTest {
	
	 private static List<Apple> apples;
	
	 @BeforeClass
	    public static void setUpClass() {
	        apples = AppleBuilder.createApples();
	    }

	@Test
	public void testFancyPrinter() {
		AppleFancyFormatter fancyFormatter = new AppleFancyFormatter();
		List<String> result = ApplePrinter.prettyPrintApple(apples, fancyFormatter);
		assertFalse(result.isEmpty());
		assertTrue(result.size() == 8);
		for(String detail : result){
			assertTrue(detail.contains("heavy") || detail.contains("light"));
		}
	}
	
	@Test
	public void testSimplePrinter() {
		AppleSimpleFormatter simpleFormatter = new AppleSimpleFormatter();
		List<String> result = ApplePrinter.prettyPrintApple(apples, simpleFormatter);
		assertFalse(result.isEmpty());
		assertTrue(result.size() == 8);
		for(String detail : result){
			assertTrue(detail.contains("An apple of "));
		}
	}

}
