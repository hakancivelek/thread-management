package week1.day1;

public class Lab1 {
    public static void main(String[] args) {

        Runnable task = () -> {
            System.out.println(Thread.currentThread().getName());
        };

        Thread thread1 = new Thread(task);

        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();
    }
}
