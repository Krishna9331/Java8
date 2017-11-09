package reactive.implementation;

import java.util.ArrayList;
import java.util.List;

public class EmailMonitor {

    private final EmailService emailService;

    public EmailMonitor(EmailService emailService, UserService userService) {
        this.emailService = emailService;

        userService.subscribeToUserEvent(this::handleUserEvent);

    }

    private void handleUserEvent(UserEvent event) {
        System.out.println("EmailMonitorService Handle user event....." + Thread.currentThread().getName());

        List<String> recipient = new ArrayList<>();
        recipient.add(event.getEmail());
        String text = "Hi " + event.getUsername() + " Welcome to our World!";

        emailService.sendEmail(recipient, "noreply@mysystem.com", "Welcome Mailer!", text);

    }
}
