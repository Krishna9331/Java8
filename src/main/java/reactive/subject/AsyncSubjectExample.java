package reactive.subject;

import reactive.helper.DataGenerator;
import rx.Observable;
import rx.subjects.AsyncSubject;

public class AsyncSubjectExample {

    public static void main(String[] args) {
        AsyncSubject<String> subject = AsyncSubject.create();

        subject.subscribe(System.out::println);


        Observable.from(DataGenerator.getGeekAlphabets())
                .subscribe(letter -> subject.onNext(letter),
                        t -> subject.onError(t),
                        () -> {
                            subject.onCompleted();
                        });
    }
}
