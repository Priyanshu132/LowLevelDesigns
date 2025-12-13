package strategyImpl;

import strategy.Payment;

public class CASH implements Payment {
    @Override
    public void pay(double amount) {
        System.out.printf(amount + " Amount Paid Using CASH");

    }
}
