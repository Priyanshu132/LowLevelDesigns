package model;

import constants.VehicleType;
import strategy.PricingStrategy;

import java.time.Duration;
import java.time.LocalTime;

public class Ticket {

    private long id;
    private VehicleType type;
    private String vehicleNumber;
    private Slot slot;
    private LocalTime entryTime;
    private PricingStrategy pricingStrategy;

    public Ticket(VehicleType type, String vehicleNumber, LocalTime entryTime,Slot slot,PricingStrategy pricingStrategy) {
        this.id = System.currentTimeMillis();
        this.pricingStrategy = pricingStrategy;
        this.type = type;
        this.vehicleNumber = vehicleNumber;
        this.entryTime = entryTime;
        this.slot = slot;
    }

    public long getId() {
        return id;
    }

    public VehicleType getType() {
        return type;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public LocalTime getEntryTime() {
        return entryTime;
    }

    public double getParkingDuration(LocalTime exitTime) {
        return Duration.between(entryTime, exitTime).toHours();
    }

    public Slot getSlot() {
        return slot;
    }

    public PricingStrategy getPricingStrategy() {
        return pricingStrategy;
    }
}
