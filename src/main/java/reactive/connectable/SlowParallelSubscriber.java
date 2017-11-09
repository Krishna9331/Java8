package reactive.connectable;

import reactive.helper.TimeTicker;
import rx.observables.ConnectableObservable;
import rx.schedulers.Schedulers;

public class SlowParallelSubscriber {

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
                .subscribe(t -> {
            System.out.println("Tick2: "+ Thread.currentThread().getName() + " :" + t);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println("sleeping for 3 sec....");
        Thread.sleep(3000);
        System.out.println("connecting...");
        connectable.connect();

        Thread.sleep(5000);
        ticker.stop();
        System.out.println("Ticker stopped......");
        Thread.sleep(5000);
    }
}
