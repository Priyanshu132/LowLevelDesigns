public class OneHundredNotesWithdraw extends CashDispenser{
    public OneHundredNotesWithdraw(CashDispenser cashDispenser) {
        super(cashDispenser);
    }

    public void withdraw(ATM atm,int amount){
        int noOfNotesRequired = amount / Currency.ONEHUNDREDNOTE.val;
        int remainingAmount = amount % Currency.ONEHUNDREDNOTE.val;

        if(noOfNotesRequired > atm.getNoOfOneHundredNotes()){
            atm.deductOneHundredNotes(atm.getNoOfOneHundredNotes());
            remainingAmount = (noOfNotesRequired - atm.getNoOfOneHundredNotes()) * Currency.ONEHUNDREDNOTE.val;
        }
        else{
            atm.deductOneHundredNotes(noOfNotesRequired);
        }

        if(remainingAmount != 0)
        {
            nextCashDispenser.withdraw(atm,remainingAmount);
        }
    }
}
