package java8.in.action.chapter2.predicate;

import java.util.ArrayList;
import java.util.List;

public class FilterList {
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p){
		List<T> reList = new ArrayList<>();
		for(T e : list){
			if(p.test(e)){
				reList.add(e);
			}
		}
		return reList;
	}

}
