package fundamentals.threadAndRunnable;

public class SharedCounter {
    private int counter = 0;

    public void doWork() {
        counter++;
        System.out.println(Thread.currentThread().getName() + " counter=" + counter);
    }
}

