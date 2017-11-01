package reactive.function;

public class SideEffectIllustration {

    private int state = 0;

    public void function2() {
        state = state + 1;
    }

    public static void main(String[] args) throws InterruptedException {
        SideEffectIllustration sideEffectIllustration = new SideEffectIllustration();
        Runnable task2 = () -> {
            for(int i = 0; i < 1000; i++)
                sideEffectIllustration.function2();
        };
        Thread [] threads = new Thread[1000];
        for(int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(task2);
            threads[i].start();
        }
        for(int i = 0; i < threads.length; i++) {
            threads[i].join();
        }
        System.out.println("The value of state is: "+ sideEffectIllustration.state);
    }
}