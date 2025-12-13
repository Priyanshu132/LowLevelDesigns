package model;

import constants.VehicleType;

import java.util.Objects;

public class Slot {

    private int id;
    private VehicleType type;
    private VehicleType parkedVehicle;
    private double basePrice;

    public Slot(int id, double basePrice,VehicleType type) {
        this.id = id;
        this.type = type;
        this.basePrice = basePrice;
    }

    public int getId() {
        return id;
    }

    public VehicleType getType() {
        return type;
    }

    public void park(VehicleType parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public boolean isFree(){
        return Objects.isNull(parkedVehicle);
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void unPark() {
        this.parkedVehicle = null;
    }
}
