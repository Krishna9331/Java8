package reactive.transformation;

import reactive.helper.DataGenerator;
import rx.Observable;

public class GeneralConditionalObservable {

    public static void main(String[] args) {
        Observable.empty()
                .defaultIfEmpty("Hello World")
                .subscribe(System.out::println);
        System.out.println();

        Observable.from(DataGenerator.getGeekAlphabets())
                .defaultIfEmpty("Hello World")
                .first()
                .subscribe(System.out::println);

        System.out.println();

        Observable.from(DataGenerator.getFibonacci())
                .skipWhile(i -> i < 8)
                .subscribe(System.out::println);

        System.out.println();

        Observable.from(DataGenerator.getFibonacci())
                .takeWhile(i -> i < 8)
                .subscribe(System.out::println);

        System.out.println();

        Observable.from(DataGenerator.getFibonacci())
                .takeWhileWithIndex((num, idx) -> idx < 3)
                .subscribe(System.out::println);
    }
}
