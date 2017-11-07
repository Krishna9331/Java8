package reactive.transformation;

import reactive.helper.DataGenerator;
import rx.Observable;

public class MapUsingObservable {

    public static void main(String[] args) {
        Observable.from(DataGenerator.getGeekAlphabets())
                .map(String::toUpperCase)
                .subscribe(System.out::println);

        System.out.println("-------------------------------------------------------------------------");

        Observable.from(DataGenerator.getGeekAlphabets())
                .flatMap(letter -> {
                    String[] retString = {letter.toUpperCase(), letter.toLowerCase()};
                    return Observable.from(retString);
                })
                .subscribe(System.out::println);
    }
}
