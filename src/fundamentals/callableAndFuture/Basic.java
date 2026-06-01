package fundamentals.callableAndFuture;

/**
 * Callable + Future Example
 *
 * <h2>Key Idea</h2>
 * Callable tasks run on a different thread and can return a result.
 * Future is a placeholder for that result.
 *
 * <h2>What is happening?</h2>
 * - Task is submitted to thread pool
 * - Main thread continues execution
 * - Result is retrieved later via Future.get()
 *
 * <h2>Blocking Point</h2>
 * future.get() blocks the main thread until result is ready.
 *
 * <h2>Why use this?</h2>
 * - When you need async execution + return value
 * - When you don’t want to block main thread immediately
 */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Basic {
    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            Thread.sleep(2000);
            return 42;
        };

        Future<Integer> future = executor.submit(task);

        System.out.println("Task submitted");

        Integer result = future.get();

        System.out.println(result);

        executor.shutdown();
    }
}
