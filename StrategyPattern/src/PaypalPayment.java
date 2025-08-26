public class PaypalPayment implements PaymentStrategy{

    private int accountNumber;

    public PaypalPayment(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    @Override
    public void pay(Double amount) {
        System.out.println("Payment Done by Paypal Account of "+amount +" using account : "+accountNumber);
    }
}
