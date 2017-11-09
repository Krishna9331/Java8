package reactive.implementation;

import rx.Observer;
import rx.functions.Action1;
import rx.subjects.PublishSubject;

public class UserServiceImpl implements UserService {

    private final PublishSubject<UserEvent> subject;

    public UserServiceImpl() {
        subject = PublishSubject.create();
    }

    @Override
    public void addUser(String userName, String email) {

        System.out.println("Adding user: " + userName + ",  " + email);
        UserEvent event = new CreateUserEvent(userName, email);
        subject.onNext(event);

    }

    @Override
    public void subscribeToUserEvent(Observer<UserEvent> event) {
        subject.subscribe(event);

    }

    @Override
    public void subscribeToUserEvent(Action1<UserEvent> onNext) {
        subject.subscribe(onNext);
    }
}
