import java.util.Objects;

public class Cart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkOut(Double amount){
        if(Objects.isNull(paymentStrategy))
            throw new RuntimeException("No Payment Selected.");
        paymentStrategy.pay(amount);
    }
}
