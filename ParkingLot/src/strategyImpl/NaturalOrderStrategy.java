package strategyImpl;

import constants.VehicleType;
import strategy.ParkingStrategy;
import model.Floor;
import model.Slot;

import java.util.*;

public class NaturalOrderStrategy extends ParkingStrategy {


    public NaturalOrderStrategy(Map<Integer, Floor> floorMap, Map<Integer, Slot> slotMap) {
        super(floorMap, slotMap);
    }

    @Override
    public Slot getSlotId(Integer floor, VehicleType type) {
        if(Objects.isNull(floor)){
            Collection<Slot> slots = slotMap.values();
            List<Slot> sortedSlots = slots.stream().sorted(Comparator.comparing(Slot::getId)).toList();
            for(Slot slot : sortedSlots)
                if(slot.isFree() && slot.getType().equals(type))
                    return slot;
            return null;
        }else{
            List<Slot> slots = floorMap.get(floor).getSlots();
            List<Slot> sorted = new ArrayList<>(slots);
            sorted.sort(Comparator.comparing(Slot::getId));
            return floorMap.get(floor).isAnySlotFree(type)
                    ? sorted.stream().filter(slot -> slot.isFree() && slot.getType().equals(type)).findFirst().get()
                    : getSlotId(null,type);
        }
    }
}
