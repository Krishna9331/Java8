package reactive.subject;

import reactive.helper.DataGenerator;
import rx.Observable;
import rx.subjects.BehaviorSubject;

public class BehaviourSubjectExample {

    public static void main(String[] args) {

        BehaviorSubject<String> subject = BehaviorSubject.create("Start state");

        subject.subscribe((letter) -> System.out.println(letter));

        Observable.from(DataGenerator.getGeekAlphabets())
                .subscribe(
                        (letter) -> subject.onNext(letter),
                        (t) -> subject.onError(t),
                        () -> {
                            System.out.println("onCompleted");
                            subject.onCompleted();
                        });

        subject.subscribe(
                (letter) -> System.out.println("Second sub: " + letter),
                (t) -> subject.onError(t),
                () -> {
                    System.out.println("onCompleted 2");
                });
    }
}
