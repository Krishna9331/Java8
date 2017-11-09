package reactive.implementation;

import java.util.List;

public interface EmailService {
    void sendEmail(List<String> recipient, String from, String subject, String text);
}
