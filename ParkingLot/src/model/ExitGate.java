package model;

import strategy.Payment;

import java.util.Objects;

public class ExitGate {

    private ParkingSystem parkingSystem;

    public ExitGate() {
        this.parkingSystem = ParkingSystem.getInstance();
    }

    public void processPayment(Ticket ticket, Payment payment){
        if(Objects.isNull(ticket))
            return;
        double amountToPay = ticket.getPricingStrategy().calculatePrice(ticket);
        payment.pay(amountToPay);

        System.out.println(" For Slot : "+ticket.getSlot().getId());

        parkingSystem.unPark(ticket.getSlot());
    }
}
