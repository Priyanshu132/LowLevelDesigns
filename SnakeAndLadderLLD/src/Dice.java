import java.util.concurrent.ThreadLocalRandom;

public class Dice {

    private int count;
    private int max;

    private int min;

    public Dice(int count,int min,int max){
        this.count = count;
        this.max = max;
        this.min = min;
    }

    public int roll(){
        int value = 0;
        for(int i = 0 ;i < count ;i++){
            value += ThreadLocalRandom.current().nextInt(min,max);
        }
        return value;
    }
}
