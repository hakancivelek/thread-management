package fundamentals.eveluation;

public class OrderResult {

    private final PaymentResult paymentResult;
    private final String status;

    public OrderResult(PaymentResult paymentResult, String status) {
        this.paymentResult = paymentResult;
        this.status = status;
    }

    public PaymentResult getPaymentResult() {
        return paymentResult;
    }

    public String getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "OrderResult{" +
                "paymentResult=" + paymentResult +
                ", status='" + status + '\'' +
                '}';
    }
}