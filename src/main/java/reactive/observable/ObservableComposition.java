package reactive.observable;

import reactive.helper.UserSecurityStatus;
import reactive.helper.UserService;
import rx.Observable;
import rx.schedulers.Schedulers;

public class ObservableComposition {

    public static void main(String[] args) throws InterruptedException {
        Object waitMonitor = new Object();
        synchronized (waitMonitor) {
            UserService userService = new UserService();
            System.out.println("\"userList\" [ {");
            Observable.from(userService.getAllUsers())
                    .parallel(userObservable -> userObservable.filter(user -> !user
                            .getUserSecurityStatus().equals(UserSecurityStatus.ADMINISTRATOR))
                            .toSortedList((user1, user2) -> user1.getUserSecurityStatus()
                                    .compareTo(user2.getUserSecurityStatus()))
                    ).subscribeOn(Schedulers.io())
                    .doOnCompleted(() -> {
                        synchronized (waitMonitor) {
                            waitMonitor.notify();
                        }
                    })
                    .subscribe( users -> users.stream().forEach(user -> System.out.println(user.toString())));
            waitMonitor.wait();
            System.out.println("] }");

        }

    }
}
