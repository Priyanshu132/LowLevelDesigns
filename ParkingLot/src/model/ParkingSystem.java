package model;

import constants.VehicleType;
import strategy.Payment;
import strategy.ParkingStrategy;
import strategy.PricingStrategy;

import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ParkingSystem {

    private static volatile ParkingSystem instance;
    private Map<Integer, Floor> floorMap;
    private Map<Integer,Slot> slotMap;
    private EntryGate entryGate;
    private ExitGate exitGate;
    private ParkingStrategy parkingStrategy;
    private Payment payment;

    private ParkingSystem(){
        floorMap = new HashMap<>();
        slotMap = new HashMap<>();
    }

    public static ParkingSystem getInstance(){
        if(instance == null){
            synchronized (ParkingSystem.class){
                if(instance == null)
                    instance = new ParkingSystem();
            }
        }
        return instance;
    }

    public Ticket park(VehicleType type, String vehicleNo, Integer floor, PricingStrategy pricingStrategy){
        Slot freeSlot = parkingStrategy.getSlotId(floor,type);
        if(Objects.isNull(freeSlot))
            return null;

        freeSlot.park(type);
        return new Ticket(type,vehicleNo, LocalTime.now(),freeSlot,pricingStrategy);
    }

    public void unPark(Slot slot){
        slot.unPark();
    }

    public int getAvailableSlots(){
        return floorMap.values().stream().mapToInt(Floor::countOfFreeSlot).sum();
    }

    public Payment getPayment() {
        return payment;
    }

    public void setFloorMap(Map<Integer, Floor> floorMap) {
        this.floorMap = floorMap;
    }

    public void setSlotMap(Map<Integer, Slot> slotMap) {
        this.slotMap = slotMap;
    }

    public void setParkingStrategy(ParkingStrategy parkingStrategy) {
        this.parkingStrategy = parkingStrategy;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setEntryGate(EntryGate entryGate) {
        this.entryGate = entryGate;
    }

    public void setExitGate(ExitGate exitGate) {
        this.exitGate = exitGate;
    }
}
