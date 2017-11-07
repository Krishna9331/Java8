package reactive.observable;

import reactive.helper.DataGenerator;
import rx.Observable;

public class ElementAtFilteringObservable {

    public static void main(String[] args) {

        Observable.from(DataGenerator.getGeekAlphabets())
                .elementAt(2)
                .subscribe(System.out::println);
        System.out.println();
        long start = System.nanoTime();
        Observable.from(DataGenerator.getGeekAlphabets())
                .elementAtOrDefault(20, "Unknown")
                .subscribe(System.out::println);
        long end = System.nanoTime();
        System.out.println("Subscribe Timing: "+ (end-start));
        long start1 = System.nanoTime();
        Observable.from(DataGenerator.getGeekAlphabets())
                .elementAtOrDefault(20, "Unknown")
                .forEach(System.out::println);
        long end1 = System.nanoTime();
        System.out.println("foreach Timing: "+ (end1-start1));
    }
}
