package fundamentals.threadCreationAndSynchronized;

public class SharedCounter {
    private int counter = 0;

    /* synchronized */ public void doWork() {
        counter++;
        System.out.println(Thread.currentThread().getName() + " counter=" + counter);
    }
}

