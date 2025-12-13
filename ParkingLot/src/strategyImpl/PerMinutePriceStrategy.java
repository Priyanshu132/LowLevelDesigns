package strategyImpl;

import strategy.PricingStrategy;
import model.Ticket;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class PerMinutePriceStrategy implements PricingStrategy {

    private static final Double COST_PER_MIN = 0.25;

    @Override
    public double calculatePrice(Ticket ticket) {
        double minutesParked = (ticket.getParkingDuration(LocalTime.now()) * 60) + Math.round(ThreadLocalRandom.current().nextDouble(1,60));
        System.out.print(minutesParked +" Minutes Vehicle Park at & ");
        return Math.round(ticket.getSlot().getBasePrice() + COST_PER_MIN * minutesParked);
    }
}
