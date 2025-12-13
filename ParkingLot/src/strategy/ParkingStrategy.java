package strategy;

import constants.VehicleType;
import model.Floor;
import model.Slot;

import java.util.Map;

public abstract class ParkingStrategy {

    public Map<Integer, Floor> floorMap;
    public Map<Integer, Slot> slotMap;

    public ParkingStrategy(Map<Integer, Floor> floorMap, Map<Integer, Slot> slotMap) {
        this.floorMap = floorMap;
        this.slotMap = slotMap;
    }

    public abstract Slot getSlotId(Integer floor, VehicleType type);

    public void freeSlotById(int id){
        slotMap.get(id).unPark();
    }

}
