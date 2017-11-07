package reactive.observable;

import reactive.helper.DataGenerator;
import rx.Observable;

public class DistinctFilterObservable {

    public static void main(String[] args) {
        System.out.println("List without distinct operation");
        Observable.from(DataGenerator.generateScrambledAlphabet())
                .subscribe(i -> System.out.print(i + " "));

        System.out.println();
        System.out.println("List after distinct operation");
        Observable.from(DataGenerator.generateScrambledAlphabet())
                .distinct()
                .subscribe(i -> System.out.print(i + " "));
    }
}
