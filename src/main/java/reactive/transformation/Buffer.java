package reactive.transformation;

import reactive.helper.TimeTicker;

import java.util.concurrent.TimeUnit;

public class Buffer {

    public static void main(String[] args) throws InterruptedException {
        TimeTicker ticker = new TimeTicker(100);
        ticker.start();
        ticker.toObservable()
                .buffer(1, TimeUnit.SECONDS)
                .subscribe(list -> {
                    System.out.println("-------------------------------------");
                    int count = 1;
                    int size = list.size();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println("" + (count++) + ": " + list.get(i));
                    }
                });
        Thread.sleep(5000);
        ticker.stop();
    }
}
