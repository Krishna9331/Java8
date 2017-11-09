package reactive.subject;

import reactive.helper.DataGenerator;
import rx.Observable;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

public class PublishSubjectExample {

    public static void main(String[] args) throws InterruptedException {
        Object signal = new Object();

        synchronized (signal) {
            PublishSubject<String> subject = PublishSubject.create();

            subject.subscribe(letter -> {
                System.out.println("Subscriber1: " + letter);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (letter.equals("Eta")) {
                    synchronized (signal) {
                        signal.notify();
                    }
                }
            });

            Observable.from(DataGenerator.getGeekAlphabets())
                    .subscribeOn(Schedulers.computation())
                    .subscribe(letter -> subject.onNext(letter),
                            t -> subject.onError(t),
                            () -> {
                                System.out.println("Subscriber 1 completed.");
                                subject.onCompleted();
                                synchronized (signal) {
                                    signal.notify();
                                }
                            });
            signal.wait();

            subject.subscribe(letter -> System.out.println("Subscriber 2: " + letter),
                    t -> subject.onError(t),
                    () -> System.out.println("Subscriber2 completed"));
            signal.wait();
        }
    }
}
