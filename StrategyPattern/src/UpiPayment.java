public class UpiPayment implements PaymentStrategy{

    private String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay(Double amount) {
        System.out.println("Payment Done of amount "+amount + " using UPI : "+upiId);
    }
}
