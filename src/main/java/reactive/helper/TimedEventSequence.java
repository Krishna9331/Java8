package reactive.helper;

import rx.Observable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TimedEventSequence<T> {

    final private long timeToWait;
    final private boolean paused = false;
    final List<T> elements;

    private Observable<T> subject;

    public TimedEventSequence(long timeToWait, List<T> elements) {
        this.timeToWait = timeToWait;
        this.elements = elements;
        this.subject = Observable.from(elements).delay(this.timeToWait, TimeUnit.MILLISECONDS);
    }

    public TimedEventSequence(long timeToWait, T[] elements) {
        this.timeToWait = timeToWait;
        this.elements = Arrays.asList(elements);
        this.subject = Observable.from(elements).delay(this.timeToWait, TimeUnit.MILLISECONDS);
    }

    public Observable<T> toObservable(){
        return this.subject;
    }

}