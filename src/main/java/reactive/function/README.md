#Reactive Manifesto
1.Even Driven
2.Scalable
3.Resilient
4.Responsive

#Observer Pattern
This pattern is used to acheive the event driven in RX java

                                       Observer   observers "subscribes" to Observable
       Observable   -----Bound to----> Observer
             ^                         Observer
             |
             |
       Information about changes
       to observable ate sent
       to the observers and the
       notification can be concurrent.

RXJava uses type constraint in above pattern so Observable<T> will be getting specific types of event and similarly
Observer<T> will get the T types of event notification. Notification are concurrent.

##example:

Observable<User>   ------->    Observer<User>                    Observer<User>             ---->    Observer<User>
(List of Users)    ------->  (Filter out non admin user) ----->  (group by security class)  ---->    (Map ORM user to JSON user bean)
                  Scheduler    Observable<User                   Observable<User>         Scheduler  Observable<User>

        The above code is manageable sized function without side effect
        RX Java is contributing for seamless concurrency


#Resilient
##It is achieved using grace full error handling
-> Handle more than happy path
-> Attempt to provide value even after failure
##Managing Failure
-> Detect if out of many instance if some of them is not responding or down and stop using it.
-> Event driven structure  that can help creating component independent of location

#Responsive
-> Slow response considered as failed, so downgrade the functionality rather than loading slowly
-> Define and implement to the desired level of performance
###Observal data Model
-> Automatic UI update via background process
-> Users generates streams of events by their actions and UI is not blocked, MVVM pattern
