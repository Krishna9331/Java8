package reactive.observable;

import reactive.helper.DataGenerator;
import rx.Observable;

import java.util.List;

public class SubscriptionAllOneThread {

    public static void main(String[] args) {

        System.out.println("Creating an observable that does not specify a subscribeOn or observeOn Scheduler");
        System.out.println("Driving Tread: "+ Thread.currentThread().getName());

        List<Integer> inList = DataGenerator.getFibonacci();

        Observable<Integer> observable = Observable.from(inList);

        observable.subscribe(
                //onNext function
                (i) -> {
                    System.out.println("onNext thread entrance: "+ Thread.currentThread().getName());
                    System.out.println(i);
                    System.out.println("onNext thread exit: "+ Thread.currentThread().getName());
                    System.out.println();
                },
                //onError function
                e -> {
                    e.printStackTrace();
                },
                //onCompleted function
                () -> System.out.println("onCompleted()")
        );
    }
}
