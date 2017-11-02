package reactive.observable.helper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UserService {

    private final List<User> allUsers;

    public UserService() {
        allUsers = new ArrayList<>();

        allUsers.add(new User("sskyprancer", "scott.skyprancer@awesomehairgoodguy.org", UserSecurityStatus.GUEST));
        allUsers.add(new User("homono", "harold.mono@ishotfirst.com", UserSecurityStatus.MODERATOR));
        allUsers.add(new User("jttent", "jarvis.t.tent@spacegangsta.com", UserSecurityStatus.ADMINISTRATOR));
        allUsers.add(new User("dvader", "darin.vader@misunderstoodempire.org", UserSecurityStatus.GUEST));
        allUsers.add(new User("lcarlosian", "londo.carlosian@bigskymining.com", UserSecurityStatus.MODERATOR));
    }

    public List<User> getAllUsers() {
        return Collections.unmodifiableList(allUsers);
    }
}
