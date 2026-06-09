package fundamentals.eveluation;

public class PaymentResult {

    private final String transactionId;

    public PaymentResult(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionId() {
        return transactionId;
    }

    @Override
    public String toString() {
        return "PaymentResult{" +
                "transactionId='" + transactionId + '\'' +
                '}';
    }
}
