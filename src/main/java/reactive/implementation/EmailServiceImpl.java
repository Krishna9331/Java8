package reactive.implementation;

import java.util.List;

public class EmailServiceImpl implements EmailService {
    @Override
    public void sendEmail(List<String> recipient, String from, String subject, String text) {
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.println("Sending Email...");
        System.out.println("--------------------------------------------------");
        System.out.println("To    :");
        recipient.stream().forEach(nxt -> System.out.printf(nxt+"; "));
        System.out.println();
        System.out.println("From: "+from);
        System.out.println("subject: "+subject);
        System.out.println("Text:    ");
        System.out.println(text);
        System.out.println();
        System.out.println("--------------------------------------------------");
    }
}
