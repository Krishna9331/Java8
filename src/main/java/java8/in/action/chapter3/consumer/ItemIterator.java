package java8.in.action.chapter3.consumer;

import java.util.List;

public class ItemIterator {
	
	public static <T> void forEach(List<T> list, Consumer<T> consumer){
		for(T i : list){
			consumer.accept(i);
		}
		
	}

}
