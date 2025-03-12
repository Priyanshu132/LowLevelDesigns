import Adaptee.WeightMachineForAdults;
import Adaptee.WeightMachineForBabies;
import Adapter.WeightMachineAdapter;
import Adapter.WeightMachineAdapterImp;

public class Main {
    public static void main(String[] args) {

        WeightMachineAdapter weightMachineForBabies = new WeightMachineAdapterImp(new WeightMachineForBabies());

        System.out.println("For Babies : "+weightMachineForBabies.getWeightInKgs() +" Kgs ");

        WeightMachineAdapter weightMachineForAdults = new WeightMachineAdapterImp(new WeightMachineForAdults());

        System.out.println("For Adults : "+weightMachineForAdults.getWeightInKgs() +" Kgs ");

    }
}