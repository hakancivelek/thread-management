package fundamentals.visibility;

/**
 * Atomicity Problem Demo
 *
 * <h2>Key Idea</h2>
 * volatile does NOT guarantee atomicity.
 * It only guarantees visibility.
 *
 * <h2>What is the problem?</h2>
 * count++ is NOT a single operation:
 * 1. Read value
 * 2. Increment
 * 3. Write back
 *
 * When multiple threads do this at the same time,
 * updates can be lost (race condition).
 *
 * <h2>Expected vs Actual</h2>
 * Expected: 200000
 * Actual: Usually less (due to lost updates)
 *
 * <h2>Fix options</h2>
 * - synchronized block
 * - AtomicInteger
 * - Lock-based solutions
 */

public class AtomicityProblem {

    volatile static int count = 0;

    public static void main(String[] args) throws InterruptedException {

        Runnable task = () -> {
            for (int i = 0; i < 100000; i++) {
                 count++; // not atomic!

//                synchronized (AtomicityProblem.class) {
//                    count++;
//                }
            }
        };

        Thread t1 = new Thread(task);
        Thread t2 = new Thread(task);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Final count: " + count);
    }
}