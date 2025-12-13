package strategy;

import constants.PaymentType;
import strategyImpl.CASH;
import strategyImpl.UPI;

public class PaymentFactory {

    public static Payment getPayment(PaymentType type){
        return switch (type) {
            case PaymentType.UPI -> new UPI();
            case PaymentType.CASH -> new CASH();
        };
    }
}
