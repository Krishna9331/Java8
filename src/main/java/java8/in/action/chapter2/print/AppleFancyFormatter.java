package java8.in.action.chapter2.print;

import common.vo.Apple;

public class AppleFancyFormatter implements AppleFormatter {
	
	@Override
	public String accept(Apple apple){
		String characteristic = apple.getWeight() > 150 ? "heavy" : "light";
		return "A " + characteristic +
		" " + apple.getColor() +" apple";
	}

}
