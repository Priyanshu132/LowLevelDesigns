public class CreditCardPayment implements PaymentStrategy{

    private Long cardNumber;
    private int cardExpiryMonth;
    private int cardExpiryYear;
    private int cardCvv;

    public CreditCardPayment(Long cardNumber, int cardExpiryYear, int cardExpiryMonth, int cardCvv) {
        this.cardNumber = cardNumber;
        this.cardExpiryYear = cardExpiryYear;
        this.cardExpiryMonth = cardExpiryMonth;
        this.cardCvv = cardCvv;
    }

    @Override
    public void pay(Double amount) {
        System.out.println("Payment Done using Credit Card of Amount : "+amount + "Using card with number : "+cardNumber);
    }
}
