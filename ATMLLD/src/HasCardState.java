import java.util.Calendar;
import java.util.Date;

public class HasCardState extends State{


    @Override
    public void authenticateCard(ATM atm, Card card){
        int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
        int currentYear =  Calendar.getInstance().get(Calendar.YEAR);

        if(card.getExpiryYear() < currentYear || (card.getExpiryYear() == currentYear && card.getExpiryMonth() < currentMonth))
            exit("Card Expired. Contact to Branch !!!");


        System.out.println("Card Authenticated.");
    }

    @Override
    public void authenticatePin(ATM atm, Card card,int pin){

        if(pin != card.getPin())
            exit("Incorrect PIN");

        System.out.println("Pin Matched.");

        atm.setCurrentState(new SelectOperationState());
    }

}
