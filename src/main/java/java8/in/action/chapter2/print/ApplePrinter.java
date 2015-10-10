package java8.in.action.chapter2.print;

import java.util.ArrayList;
import java.util.List;

import com.oracle.java8.vo.Apple;

public class ApplePrinter {

	public static List<String> prettyPrintApple(List<Apple> inventory,
			AppleFormatter formatter) {
		List<String> result = new ArrayList<String>();
		for (Apple apple : inventory) {
			result.add(formatter.accept(apple));
		}
		return result;
	}

}
