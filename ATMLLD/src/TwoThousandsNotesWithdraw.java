public class TwoThousandsNotesWithdraw extends CashDispenser {

    public TwoThousandsNotesWithdraw(CashDispenser cashDispenser) {
        super(cashDispenser);
    }

    public void withdraw(ATM atm,int amount){
        int noOfNotesRequired = amount / Currency.TWOTHOUSANDSNOTE.val;
        int remainingAmount = amount % Currency.TWOTHOUSANDSNOTE.val;

        if(noOfNotesRequired > atm.getNoOfTwoThousandNotes()){
            atm.deductTwoThousandNotes(atm.getNoOfTwoThousandNotes());
            remainingAmount = (noOfNotesRequired - atm.getNoOfTwoThousandNotes()) * Currency.TWOTHOUSANDSNOTE.val;
        }
        else{
            atm.deductTwoThousandNotes(noOfNotesRequired);
        }

        if(remainingAmount != 0)
        {
            nextCashDispenser.withdraw(atm,remainingAmount);
        }
    }
}
