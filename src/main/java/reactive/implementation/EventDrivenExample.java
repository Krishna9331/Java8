package reactive.implementation;

public class EventDrivenExample {

    public static void main(String[] args) {
        try {
            EmailService emailService = new EmailServiceImpl();
            UserService userService = new UserServiceImpl();
            new EmailMonitor(emailService, userService);
            userService.addUser("krishna", "kkm@mymail.com");
            Thread.sleep(2000);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }
}
