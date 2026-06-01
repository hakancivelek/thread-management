package fundamentals.visibility;

/**
 * Java Visibility Problem Demo (volatile)
 *
 * <h2>Experiment 1 (WITHOUT volatile)</h2>
 * Remove {@code volatile} from flag and run the program.
 * Thread-2 may never stop because it can read a cached value.
 *
 * <h2>Experiment 2 (WITH volatile)</h2>
 * With {@code volatile}, changes made by Thread-1 are
 * immediately visible to Thread-2, so the loop stops correctly.
 *
 * <h2>Key Idea</h2>
 * volatile ensures visibility across threads.
 * It does NOT guarantee atomicity.
 */

public class VisibilityExample {

    volatile static boolean flag = false;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println("Thread-1 started");

            try { Thread.sleep(100); } catch (Exception e) {}

            flag = true; // changed
            System.out.println("Thread-1 set flag: true");
        });

        Thread t2 = new Thread(() -> {
            System.out.println("Thread-2 started and the flag is: " + flag);

            while (!flag) {
                // waiting
            }

            System.out.println("Flag is true on Thread-2");
        });

        t1.start();
        t2.start();
    }
}
