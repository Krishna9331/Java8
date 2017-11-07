package reactive.observable;

import reactive.observable.helper.TimeTicker;

import java.util.concurrent.TimeUnit;

public class TimeBasedTimeoutObservable {

    public static void main(String[] args) throws InterruptedException {
        TimeTicker ticker = new TimeTicker(100);
        ticker.start();

        try {
            ticker.toObservable()
                    .timeout(3, TimeUnit.SECONDS)
                    .subscribe(t -> System.out.println("tick: " + t),
                            exception -> {
                                System.out.println("Timeout!!!");
                                exception.printStackTrace();
                            });
            Thread.sleep(1000);
            System.out.println("pausing ticker");
            ticker.pause();
            Thread.sleep(5000);
        } finally {
            ticker.stop();
        }
    }
}
