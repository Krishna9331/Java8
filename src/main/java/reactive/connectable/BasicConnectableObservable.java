package reactive.connectable;

import reactive.helper.TimeTicker;
import rx.observables.ConnectableObservable;

public class BasicConnectableObservable {

    public static void main(String[] args) throws InterruptedException {

        TimeTicker ticker = new TimeTicker(500);
        ticker.start();

        ConnectableObservable<Long> connectable = ticker
                                                    .toObservable()
                                                    .publish();

        connectable.subscribe(t -> System.out.println("Tick: "+ Thread.currentThread().getName() + " :" + t));

        System.out.println("sleeping for 3 sec....");
        Thread.sleep(3000);
        System.out.println("connecting...");
        connectable.connect();

        Thread.sleep(3000);
        ticker.stop();

    }
}
