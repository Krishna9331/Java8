package java8.in.action.chapter3.function;

import java.util.ArrayList;
import java.util.List;

public class Processor {
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> function){
		List<R> result = new ArrayList<>();
		for(T t : list){
			result.add(function.apply(t));
		}
		
		return result;
	}

}
