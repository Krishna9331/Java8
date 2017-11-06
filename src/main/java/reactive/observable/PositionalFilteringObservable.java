package reactive.observable;

import reactive.observable.helper.DataGenerator;
import rx.Observable;

public class PositionalFilteringObservable {

    public static void main(String[] args) {
        System.out.println("------------First------------->");
        Observable.from(DataGenerator.getGeekAlphabets())
                .first()
                .subscribe(System.out::println);

        System.out.println("------------Last-------------->");

        Observable.from(DataGenerator.getGeekAlphabets())
                .last()
                .subscribe(System.out::println);

        System.out.println("-------------First 4---------->");

        Observable.from(DataGenerator.getGeekAlphabets())
                .take(4)
                .subscribe(System.out::println);

        System.out.println("------------Last 4------------>");

        Observable.from(DataGenerator.getGeekAlphabets())
                .takeLast(4)
                .subscribe(System.out::println);

        System.out.println("--------first or default------>");

        Observable.from(DataGenerator.getGeekAlphabets())
                .firstOrDefault("Empty list")
                .subscribe(System.out::println);

        System.out.println("--------last or default------->");

        Observable.from(DataGenerator.getEmptyGeekAlphabets())
                .lastOrDefault("Empty List")
                .subscribe(System.out::println);

        System.out.println("---first with predicates------>");

        Observable.from(DataGenerator.getGeekAlphabets())
                .first(letter -> letter.contains("Mishra"))
                .subscribe(System.out::println);

        System.out.println("----last with predicates------>");

        Observable.from(DataGenerator.getGeekAlphabets())
                .last(letter -> letter.contains("Mishra"))
                .subscribe(System.out::println);
    }
}
