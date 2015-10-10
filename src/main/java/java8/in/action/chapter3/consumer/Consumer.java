package java8.in.action.chapter3.consumer;

@FunctionalInterface
public interface Consumer<T> {
	
	void accept(T t);

}
