package reactive.implementation;

import rx.functions.Action1;
import rx.Observer;

public interface UserService {

    void addUser(String userName, String email);

    void subscribeToUserEvent(Observer<UserEvent> event);
    void subscribeToUserEvent(Action1<UserEvent> onNext);
}
