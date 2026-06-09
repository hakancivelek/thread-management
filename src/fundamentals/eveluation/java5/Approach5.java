package fundamentals.eveluation.java5;

import fundamentals.eveluation.*;
import java.util.concurrent.*;

public class Approach5 {

    private final StockService stockService = new StockService();
    private final PaymentService paymentService = new PaymentService();
    private final ShipmentService shipmentService = new ShipmentService();
    private final EmailService emailService = new EmailService();

    public OrderResult processOrder(Order order) {

        ExecutorService pool = Executors.newFixedThreadPool(4);

        // 1. Stock check (base dependency)
        CompletableFuture<Boolean> stockFuture =
                CompletableFuture.supplyAsync(() -> stockService.check(order), pool);

        // 2. Payment depends on stock
        CompletableFuture<PaymentResult> paymentFuture =
                stockFuture.thenCompose(stockAvailable -> {
                    if (!stockAvailable) {
                        throw new RuntimeException("Out of stock!");
                    }
                    return CompletableFuture.supplyAsync(
                            () -> paymentService.process(order),
                            pool
                    );
                });

        // 3. Shipment depends ONLY on stock (independent from payment)
        CompletableFuture<ShipmentNo> shipmentFuture =
                stockFuture.thenCompose(stockAvailable -> {
                    if (!stockAvailable) {
                        throw new RuntimeException("No shipment possible");
                    }
                    return CompletableFuture.supplyAsync(
                            () -> shipmentService.create(order),
                            pool
                    );
                });

        // 4. Email depends on payment
        CompletableFuture<Void> emailFuture =
                paymentFuture.thenAccept(payment ->
                        emailService.send(order, payment)
                );

        CompletableFuture.allOf(paymentFuture, shipmentFuture, emailFuture).join();

        pool.shutdown();

        return new OrderResult(paymentFuture.join(), "done");
    }

    // Mock Services

    private static class StockService {
        Boolean check(Order order) {
            sleep(200);
            System.out.println("Stock checked: " + order.getId());
            return true;
        }
    }

    private static class PaymentService {
        PaymentResult process(Order order) {
            sleep(1000);
            System.out.println("Payment processed: " + order.getId());
            return new PaymentResult("PAY-" + order.getId());
        }
    }

    private static class ShipmentService {
        ShipmentNo create(Order order) {
            sleep(300);
            System.out.println("Shipment created: " + order.getId());
            return new ShipmentNo("SHIP-" + order.getId());
        }
    }

    private static class EmailService {
        void send(Order order, PaymentResult payment) {
            System.out.println(
                    "Email sent for order "
                            + order.getId()
                            + " | payment: "
                            + payment.getTransactionId()
            );
        }
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}