package strategyImpl;

import strategy.Payment;

public class UPI implements Payment {


    @Override
    public void pay(double amount) {
        System.out.printf(amount + " Amount Paid Using UPI");
    }
}
