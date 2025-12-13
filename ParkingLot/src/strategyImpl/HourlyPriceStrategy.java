package strategyImpl;

import strategy.PricingStrategy;
import model.Ticket;

import java.time.LocalTime;
import java.util.concurrent.ThreadLocalRandom;

public class HourlyPriceStrategy implements PricingStrategy {

    private static final Double COST_PER_HOUR = 5.0;

    @Override
    public double calculatePrice(Ticket ticket) {
        double hoursParked = ticket.getParkingDuration(LocalTime.now()) + Math.round(ThreadLocalRandom.current().nextDouble(1,10));
        System.out.print(hoursParked +" Hours Vehicle Park at & ");
        return Math.round(ticket.getSlot().getBasePrice() + COST_PER_HOUR * hoursParked);
    }
}
