package strategyImpl;

import strategy.SplitStrategy;

public class EqualStrategy implements SplitStrategy {

    @Override
    public float getShareAmount(float amount,int member) {
        return amount / member;
    }
}
