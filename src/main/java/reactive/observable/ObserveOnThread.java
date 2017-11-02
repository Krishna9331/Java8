package reactive.observable;

import reactive.observable.helper.DataGenerator;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.List;

public class ObserveOnThread {

    public static void main(String[] args) throws InterruptedException {
        Object waitMonitor = new Object();

        synchronized (waitMonitor) {
            System.out.println("Creating an observable that does not specify a subscribeOn or observeOn Scheduler");
            System.out.println("Driving Tread: " + Thread.currentThread().getName());

            List<Integer> inList = DataGenerator.getFibonacci();

            Observable<Integer> observable = Observable.from(inList);

            //The below lines will make the observe call on io Scheduler but still it will be synchronus.
            //We did not specify the parallelism.
            observable
                    .observeOn(Schedulers.io())
                    .subscribe(
                            //onNext function
                            (i) -> {
                                System.out.println("onNext thread entrance: " + Thread.currentThread().getName());
                                System.out.println(i);
                                System.out.println("onNext thread exit: " + Thread.currentThread().getName());
                                System.out.println();
                            },
                            //onError function
                            e -> {
                                e.printStackTrace();
                            },
                            //onCompleted function
                            () -> {
                                System.out.println("onCompleted()");
                                synchronized (waitMonitor){
                                    waitMonitor.notify();
                                }
                            }
                    );
            waitMonitor.wait();
        }
    }
}
