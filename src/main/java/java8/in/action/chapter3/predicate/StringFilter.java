package java8.in.action.chapter3.predicate;

import java.util.ArrayList;
import java.util.List;

public class StringFilter {
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p){
		List<T> result = new ArrayList<>();
		for(T s : list){
			if(p.test(s)){
				result.add(s);
			}
		}
		return result;
	}

}
