package reactive.connectable;

import reactive.helper.TimeTicker;
import rx.observables.ConnectableObservable;
import rx.schedulers.Schedulers;

public class ParallelObserveOn {

    public static void main(String[] args) throws InterruptedException {
        TimeTicker ticker = new TimeTicker(500);
        ticker.start();

        ConnectableObservable<Long> connectable = ticker
                .toObservable()
                .publish();

        connectable
                .observeOn(Schedulers.computation())
                .subscribe(t -> System.out.println("Tick: "+ Thread.currentThread().getName() + " :" + t));

        connectable
                .observeOn(Schedulers.computation())
                .subscribe(t -> System.out.println("Tick2: "+ Thread.currentThread().getName() + " :" + t));

        System.out.println("sleeping for 3 sec....");
        Thread.sleep(3000);
        System.out.println("connecting...");
        connectable.connect();

        Thread.sleep(3000);
        ticker.stop();
    }
}
