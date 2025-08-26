//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {


        Cart cart = new Cart();
        cart.setPaymentStrategy(new CreditCardPayment(123L,1,12,22));
        cart.checkOut(2996.9);

        cart.setPaymentStrategy(new PaypalPayment(12345));
        cart.checkOut(56545.0);

        cart.setPaymentStrategy(new UpiPayment("9866568@paytm"));
        cart.checkOut(864.56);

    }
}