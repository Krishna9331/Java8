package reactive.observable;


import reactive.observable.helper.DataGenerator;
import rx.Observable;

public class SimpleObservable {

    public static void main(String[] args) {

        Observable<Integer> observable = null;

        System.out.println("Simple Observable creation from single value ------->");
        observable = Observable.from(Integer.valueOf(42));
        observable.subscribe(i -> System.out.println(i));

        System.out.println("Simple Observable creation from iterable -------> ");
        observable = Observable.from(DataGenerator.getFibonacci());
        observable.subscribe(i -> System.out.println(i));

        System.out.println("Simple Observable creation from an array -------> ");
        observable = Observable.from(DataGenerator.getFibonacciArray());
        observable.subscribe(i -> System.out.println(i));
    }

}
