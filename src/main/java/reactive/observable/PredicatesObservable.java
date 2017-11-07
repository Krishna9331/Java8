package reactive.observable;

import reactive.helper.DataGenerator;
import rx.Observable;

public class PredicatesObservable {

    public static void main(String[] args) {
        Observable.from(DataGenerator.generateBigIntegers())
                .filter(i -> i % 3 == 0 && i < 20)
                .subscribe(System.out::println);
    }
}
