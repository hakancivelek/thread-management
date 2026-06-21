package week1.day1;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Lab3 {
    public static void main(String[] args) throws Exception {
        ExecutorService executor =
                Executors.newFixedThreadPool(1);

        Callable<Integer> task = () -> {

            System.out.println("Task started");

            Thread.sleep(5000);

            System.out.println("Task finished");

            return 42;
        };

        Future<Integer> future =
                executor.submit(task);

        System.out.println("Task submitted");

        System.out.println("Result not yet retrieved");

        Thread.sleep(2000);

        System.out.println("2 seconds passed");

        Integer result = future.get();

        System.out.println("Result = " + result);

        executor.shutdown();
    }
}