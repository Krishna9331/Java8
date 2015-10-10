package java8.in.action.chapter3.predicate;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

public class StringFilterTest {

	private static List<String> names;
	@BeforeClass
	 public static void setUpClass() {
		names = new ArrayList<String>();
		names.add("Krishna");
		names.add("KK");
		names.add("Ghutru");
		names.add("");
		names.add("Mishra");
		names.add("");
		names.add("Kant");
	}
	@Test
	public void testNonEmptyString() {
		List<String> nonEmptyNames = StringFilter.filter(names, s -> !s.isEmpty());
		for(String name : nonEmptyNames){
			assertTrue(name.length() > 0);
		}
	}
	
	@Test
	public void testEmptyString() {
		List<String> nonEmptyNames = StringFilter.filter(names, s -> s.isEmpty());
		for(String name : nonEmptyNames){
			assertTrue(name.length() == 0);
		}
	}

}
