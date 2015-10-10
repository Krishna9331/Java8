package java8.in.action.chapter3.function;

@FunctionalInterface
public interface Function<T, R> {
	
	R apply(T t);

}
