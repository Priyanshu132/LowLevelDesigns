public class FiveHundredNotesWithdraw extends CashDispenser{
    public FiveHundredNotesWithdraw(CashDispenser cashDispenser) {
        super(cashDispenser);
    }

    @Override
    public void withdraw(ATM atm,int amount){

        int noOfNotesRequired = amount / Currency.FIVEHUNDREDNOTE.val;
        int remainingAmount = amount % Currency.FIVEHUNDREDNOTE.val;

        if(noOfNotesRequired > atm.getNoOfFiveHundredNotes()){
            atm.deductFiveHundredNotes(atm.getNoOfFiveHundredNotes());
            remainingAmount = (noOfNotesRequired - atm.getNoOfFiveHundredNotes()) * Currency.FIVEHUNDREDNOTE.val;
        }
        else{
            atm.deductFiveHundredNotes(noOfNotesRequired);
        }

        if(remainingAmount != 0)
        {
            nextCashDispenser.withdraw(atm,remainingAmount);
        }
    }
}
