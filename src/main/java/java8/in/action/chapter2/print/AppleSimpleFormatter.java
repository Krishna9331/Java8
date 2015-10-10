package java8.in.action.chapter2.print;

import common.vo.Apple;

public class AppleSimpleFormatter implements AppleFormatter {

	@Override
	public String accept(Apple apple) {
		return "An apple of " + apple.getWeight() + "g";
	}

}
