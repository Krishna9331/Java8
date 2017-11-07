package reactive.transformation;

import reactive.helper.DataGenerator;
import rx.Observable;

public class GroupBy {

    public static void main(String[] args) {
        Observable.from(DataGenerator.generateBigIntegers())
                //maintains the order of event
                .groupBy(i -> i % 2 == 0 ? "Even" : "Odd")
                .subscribe(grpList -> {
                    System.out.println("Key: " + grpList.getKey() + "------------------------------");
                    grpList.subscribe(x -> System.out.println(grpList.getKey() +": "+ x));
                });
    }
}
