package reactive.observable;

import reactive.observable.helper.DataGenerator;
import rx.Observable;

public class ElementAtFilteringObservable {

    public static void main(String[] args) {

        Observable.from(DataGenerator.getGeekAlphabets())
                .elementAt(2)
                .subscribe(System.out::println);
        System.out.println();
        Observable.from(DataGenerator.getGeekAlphabets())
                .elementAtOrDefault(20, "Unknown")
                .subscribe(System.out::println);
    }
}
