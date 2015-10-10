package java8.in.action.chapter2.print;

import com.oracle.java8.vo.Apple;

public class AppleSimpleFormatter implements AppleFormatter {

	@Override
	public String accept(Apple apple) {
		return "An apple of " + apple.getWeight() + "g";
	}

}
