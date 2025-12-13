import constants.PaymentType;
import constants.VehicleType;
import model.*;
import strategy.Payment;
import strategy.PaymentFactory;
import strategyImpl.*;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;


public class Main {
    public static void main(String[] args) {

        ParkingSystem system = ParkingSystem.getInstance();
        Map<Integer,Slot> slotMap = new HashMap<>();
        Map<Integer,Floor> floorMap = new HashMap<>();

        // five floors parking
        IntStream.range(1,3).forEach(floorId->{
            floorMap.put(floorId,new Floor(floorId,IntStream.iterate(floorId * 100,i-> i + 1).limit(3).mapToObj(slotId-> {
                int type = ThreadLocalRandom.current().nextInt(0,VehicleType.values().length);
                Slot slot =  new Slot(slotId,10 * (type + 1), VehicleType.values()[type]);
                slotMap.put(slotId,slot);
                return slot;
            }).toList()));
        });

        system.setFloorMap(floorMap);
        system.setSlotMap(slotMap);
        system.setParkingStrategy(new NaturalOrderStrategy(floorMap,slotMap));
        EntryGate entryGate = new EntryGate();
        ExitGate exitGate = new ExitGate();
        system.setEntryGate(entryGate);
        system.setExitGate(exitGate);


        System.out.println("----- Available Slots => "+system.getAvailableSlots());

        Ticket ticket1 = entryGate.issueTicket(VehicleType.BIKE,"HR 98 P1489",2,new HourlyPriceStrategy());

        Ticket ticket2 = entryGate.issueTicket(VehicleType.CYCLE,"UP 21 P1489",1,new PerMinutePriceStrategy());

        Ticket ticket3 = entryGate.issueTicket(VehicleType.TRUCK,"KA 08 P1489",null,new HourlyPriceStrategy());

        Ticket ticket4 = entryGate.issueTicket(VehicleType.BIKE,"HR 98 K6377",null,new HourlyPriceStrategy());

        Ticket ticket5 = entryGate.issueTicket(VehicleType.CAR,"UP 26 L3241",null,new PerMinutePriceStrategy());


        System.out.println("----- Available Slots => "+system.getAvailableSlots());

        exitGate.processPayment(ticket3, PaymentFactory.getPayment(PaymentType.UPI));

        exitGate.processPayment(ticket1, PaymentFactory.getPayment(PaymentType.UPI));

        exitGate.processPayment(ticket2, PaymentFactory.getPayment(PaymentType.CASH));

        exitGate.processPayment(ticket5, PaymentFactory.getPayment(PaymentType.UPI));

        exitGate.processPayment(ticket4, PaymentFactory.getPayment(PaymentType.CASH));


        System.out.println("----- Available Slots => "+system.getAvailableSlots());


    }
}