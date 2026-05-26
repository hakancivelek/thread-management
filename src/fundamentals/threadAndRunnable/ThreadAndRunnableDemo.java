package fundamentals.threadAndRunnable;

public class ThreadAndRunnableDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("=== Using extends Thread (same object passed, still works but not flexible) ===");
        SharedCounter counter1 = new SharedCounter();
        ThreadExtendExample threadA = new ThreadExtendExample(counter1);
        ThreadExtendExample threadB = new ThreadExtendExample(counter1);
        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();

        System.out.println("\n=== Using implements Runnable (natural sharing, better design) ===");
        SharedCounter counter2 = new SharedCounter();
        RunnableExample task = new RunnableExample(counter2);
        Thread worker1 = new Thread(task, "Worker-1");
        Thread worker2 = new Thread(task, "Worker-2");
        worker1.start();
        worker2.start();
        worker1.join();
        worker2.join();
    }
}
