package reactive.implementation;

public class CreateUserEvent extends UserEvent {

    public CreateUserEvent(String username, String email) {
        super(username, email);
    }
}
