package reactive.transformation;

import reactive.helper.DataGenerator;
import reactive.helper.TimeTicker;
import reactive.helper.TimedEventSequence;

public class TimeConditionalSkipUntil {

    public static void main(String[] args) throws InterruptedException {
        TimedEventSequence<String> sequence1 = new TimedEventSequence<>(50, DataGenerator.getGeekAlphabets());
        TimeTicker timeTicker = new TimeTicker(3000);

        sequence1.toObservable().skipUntil(timeTicker.toObservable())
                .subscribe((x) -> System.out.println(x));
        timeTicker.start();

        Thread.sleep(5000);
    }
}
