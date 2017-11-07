package reactive.observable.helper;

import rx.Observable;
import rx.subjects.BehaviorSubject;

public class TimeTicker {

    private final BehaviorSubject<Long> tickerSubject;
    private final long interval;

    private volatile boolean paused;
    private long lastTick;
    private Thread tickerThread;

    public TimeTicker(long interval) {
        lastTick = System.currentTimeMillis();
        tickerSubject = BehaviorSubject.create(lastTick);
        tickerThread = null;
        paused = false;
        this.interval = interval;
    }

    public Observable<Long> toObservable() {
        return tickerSubject;
    }

    public synchronized void start() {
        if(tickerThread != null){
            return;
        }

        unpause();

        tickerThread = new Thread(() -> {
            try {
                while (Thread.interrupted() == false) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException ex) {
                        break;
                    }

                    if(paused){
                        continue;
                    }

                    long currentTime = System.currentTimeMillis();
                    if(currentTime - lastTick > interval) {
                        lastTick = currentTime;
                        tickerSubject.onNext(lastTick);
                    }
                }
            } catch (Throwable t) {
                tickerSubject.onError(t);
            }
            tickerSubject.onCompleted();
        }, "TickerThread");
        tickerThread.start();
    }

    public synchronized void stop() {
        if (tickerThread == null) {
            return;
        }
        tickerThread.interrupt();

        try {
            tickerThread.join();
        }catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public void unpause() {
        paused = false;
    }

    public void pause() {
        paused = true;
    }
}
