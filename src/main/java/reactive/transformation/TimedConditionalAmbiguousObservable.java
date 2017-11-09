package reactive.transformation;

import reactive.helper.DataGenerator;
import reactive.helper.TimeTicker;
import reactive.helper.TimedEventSequence;
import rx.Observable;

public class TimedConditionalAmbiguousObservable {

    public static void main(String[] args) throws InterruptedException {

        TimedEventSequence<String> ticker1 = new TimedEventSequence(40, DataGenerator.getGeekAlphabets());
        TimedEventSequence<String> ticker2 = new TimedEventSequence(30, DataGenerator.getFibonacci());

        Observable.amb(ticker1.toObservable(), ticker2.toObservable())
                .subscribe(System.out::println);

        Thread.sleep(4000);
    }
}
