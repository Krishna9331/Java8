package java8.in.action.chapter3.predicate;

@FunctionalInterface
public interface Predicate<T> {
	
	boolean test(T t);

}
