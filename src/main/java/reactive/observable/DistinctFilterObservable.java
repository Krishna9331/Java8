package reactive.observable;

import reactive.observable.helper.DataGenerator;
import rx.Observable;

public class DistinctFilterObservable {

    public static void main(String[] args) {
        System.out.println("List without distinct operation");
        Observable.from(DataGenerator.generateScrambledAlphabet())
                .subscribe(System.out::print);

        System.out.println();
        System.out.println("List without distinct operation");
        Observable.from(DataGenerator.generateScrambledAlphabet())
                .distinct()
                .subscribe(System.out::print);
    }
}
