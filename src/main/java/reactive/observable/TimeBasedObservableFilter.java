package reactive.observable;

import reactive.observable.helper.TimeTicker;

import java.util.concurrent.TimeUnit;

public class TimeBasedObservableFilter {

    public static void main(String[] args) throws InterruptedException {
        TimeTicker ticker = new TimeTicker(10);
        ticker.start();

        try {
            ticker.toObservable()
                    .sample(1, TimeUnit.SECONDS)
                    .subscribe(t -> System.out.println("tick: "+ t));
            Thread.sleep(100000);
        } finally {
            ticker.stop();
        }
    }
}
