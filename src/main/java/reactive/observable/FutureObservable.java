package reactive.observable;

import reactive.observable.helper.DataGenerator;
import rx.Observable;
import rx.schedulers.Schedulers;

import java.util.List;
import java.util.concurrent.FutureTask;

public class FutureObservable {

    public static void main(String[] args) {
        Observable<List<Integer>> observableFutureList;

        //create future task that returns List<Integer>
        FutureTask<List<Integer>> futureTask = new FutureTask<>(DataGenerator::getFibonacci);

        //construct an observable. The below code only creates the observable wrapper around the future, which still need
        // to be executed using run method or by scheduling it to execute.

        observableFutureList = Observable.from(futureTask);

        //schedule the future to run on computational Scheduler
        Schedulers.computation().createWorker().schedule(futureTask::run);

        //Subscribe to list so that when list is ready through future iterate and print it.
        observableFutureList.subscribe(list -> list.stream().forEach(System.out::println));
    }
}
