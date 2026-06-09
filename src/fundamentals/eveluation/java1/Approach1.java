package fundamentals.eveluation.java1;

public class Approach1 {

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Order process started");

        Thread stockThread = new Thread(() -> {
            System.out.println("Stock check started");

            try {
                Thread.sleep(200);
                throw new RuntimeException("Stock failed");
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("Stock check finished");
        });

        Thread paymentThread = new Thread(() -> {
            System.out.println("Payment started");

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            System.out.println("Payment finished");
        });

        stockThread.start();
        stockThread.join();

        paymentThread.start();
        paymentThread.join();

        System.out.println("Order completed (unknown success state)");
    }
}