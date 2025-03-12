package Adapter;

import Adaptee.WeightMachine;

public class WeightMachineAdapterImp implements WeightMachineAdapter{

    WeightMachine weightMachine;

    public WeightMachineAdapterImp(WeightMachine weightMachine){
        this.weightMachine = weightMachine;
    }

    @Override
    public double getWeightInKgs() {
        return weightMachine.getWeightInPounds() * .45;
    }
}
