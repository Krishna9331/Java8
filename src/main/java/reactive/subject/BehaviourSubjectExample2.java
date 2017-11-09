package reactive.subject;

import reactive.helper.DataGenerator;
import rx.Observable;
import rx.subjects.BehaviorSubject;

public class BehaviourSubjectExample2 {
    public static void main(String[] args) {

        BehaviorSubject<String> subject = BehaviorSubject.create("start state");

        subject.subscribe(System.out::println);
        subject.subscribe(
                letter -> System.out.println("Subscriber 2: " + letter),
                t -> subject.onError(t),
                () -> System.out.println("Subscriber2 completed"));

        Observable.from(DataGenerator.getGeekAlphabets())
                .subscribe(letter -> subject.onNext(letter),
                        t -> subject.onError(t),
                        () -> {
                            System.out.println("OnCompleted.");
                            subject.onCompleted();
                        });
    }

}
