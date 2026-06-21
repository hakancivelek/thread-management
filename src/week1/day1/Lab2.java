package week1.day1;

import java.util.concurrent.*;

public class Lab2 {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Callable<Integer> task = () -> {
            Thread.sleep(2000);
            return 100;
        };

        Future<Integer> future = executor.submit(task);

        System.out.println("Waiting for the result");

        try {
            System.out.println(future.get());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        executor.shutdown();
    }
}
