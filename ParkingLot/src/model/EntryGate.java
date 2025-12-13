package model;

import constants.VehicleType;
import strategy.PricingStrategy;

import java.util.Objects;

public class EntryGate {

    private ParkingSystem parkingSystem;

    public EntryGate() {
        this.parkingSystem = ParkingSystem.getInstance();
    }

    public Ticket issueTicket(VehicleType type, String vehicleNo, Integer floor, PricingStrategy pricingStrategy){
        Ticket ticket =  parkingSystem.park(type,vehicleNo,floor,pricingStrategy);
        if(Objects.isNull(ticket)){
            System.out.println("Parking is Full and can't parked your Vehicle("+vehicleNo+")");
        }else
            System.out.println("Vehicle with No. "+vehicleNo +" Parked at Slot : "+ticket.getSlot().getId());
        return ticket;
    }
}
