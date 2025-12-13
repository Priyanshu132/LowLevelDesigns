package strategy;

import model.Ticket;

public interface PricingStrategy {

    double calculatePrice(Ticket ticket);
}
