package reactive.transformation;

import reactive.helper.DataGenerator;
import rx.Observable;

public class ScanUsingObservable {

    public static void main(String[] args) {
        Observable.from(DataGenerator.getGeekAlphabets())
                .scan(new StringBuilder(), (accumBuffer, next) -> accumBuffer.append(next))
                .subscribe(total -> System.out.println("Scan Event: " + total.toString()));

        System.out.println("------------------------------------------------------------");

        Observable.from(DataGenerator.getGeekAlphabets())
                .scan(new StringBuilder(), (acc, nxt) -> acc.append(nxt))
                .last()
                .subscribe(total -> System.out.println("Scan Event: " + total.toString()));
    }
}
