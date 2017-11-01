#Observable
Observable is created by implementing the Observer interface, It has three methods
1.onNext(T): It is called each time when a observer communicate with it's published Observable. In this method we perform
              some action on each event.
2.onCompleted(T): It is called when a sequence of event associated with observable is complete.
3.onError(Throwable t): It is called when some unhandled exception occurs, after this no further call of onNext or onCompleted
                        is expected.

The Subscription interface is another important entity in Observable it has onely one method:
1. unsubscribe(): it is called by observer wants to unsubscribe from Observable.

#The return type of subscribe method is Subscription interface.

There are two types of Observable:
#Non-Blocking extends Observable class
 This supports asynchronous execution means we can request the event to be executed in different thread.
 Also it allows unsubsribing at any point of event stream.
Note: Rx Java is single threaded by default

#Blocking Observable extends BlockingObservable class which extends Observable class.
 All events are synchronous.
 We can not unsubscribe in middle of event stream.

Schedulers is used for asynchronus which provide certain pre packaged options:
#computation(): Number of thread equal to number of core in processor, useful for computational work.
#currentThread(): It indicated that once the current work is finished, we want our event code to run in the current thread.
#immediate(): It is contrast to currentThread(), which does not allow current work to finish
              but immediately invoke the handler code within the current thread.
#io(): This scheduler is used by long running IO process, N/W process or DB communication, It is backed by a thread pool
       which grow as needed.
#newThread(): This scheduler is used when we want new thread for each unit of work.
#executor(Executor): It is used to wrap the Java Executor interface
#executor(ScheduledExecutor): Used for Java scheduler integration

By default Java Rx is single threaded but we use Scheduler via Observable to implement Concurrency. The below two method
is used to include scheduler, However java leaves the responsiblity of handling concurrency completely to us:
#subscribeOn(Scheduler): It decided the threads on which our method will run depending on the Scheduler passed. If we do
not specify Scheduler then our method will run in current thread.
#observeOn(Scheduler): This methods decided the Scheduler for onNext, onCompleted and onError, If we do not specify Scheduler
then all method will be executed using Scheduler of subscribeOn(). Again if we do not specify Scheduler for subscribeOn()
then it will be executed in current thread.

Observable is created using from method (static factory method) of Observable, It is overloaded as below:
1. <T> Observable<T> Observable.from(T object[, Scheduler s])
2. <T> Observable<T> Observable.from(Iterable<T> list[, Scheduler s])
3. <T> Observable<T> Observable.from(T [] array[, Scheduler s])
4. <T> Observable<T> Observable.from(Future<T> future[, Scheduler s])

Similarly we have from method for BlockingObservable as well:
<T> Observable<T> BlockingObservable.from(Observable o)
