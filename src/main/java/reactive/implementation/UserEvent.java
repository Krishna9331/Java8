package reactive.implementation;

import java.util.Date;

public class UserEvent {
    private final String username;
    private final String email;
    private final Date eventDate;

    public UserEvent(String username, String email) {
        this.username = username;
        this.email = email;
        this.eventDate = new Date();
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public Date getEventDate() {
        return eventDate;
    }
}
