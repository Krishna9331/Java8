Subject contains both Subscriber and Observable. It gives easy way to create code which is event based.
1. Subscriber: Subscribe to more than one event coming from Observable.
2. Observable: Reemit events, Drive new event(onNext, onError and onCompleted)

There are three types of Subject:
1. PublishSubject: It emits the event to subscriber after the point of subscription. Event emitted before that will not be givrn to subscriber.
2. BehaviourSubject: This subject requires the start state event and the the last publish event in this state is the first event that the new subscriber see.
3. AsynSubject: It emits only the last event seen before the onCompleted call.