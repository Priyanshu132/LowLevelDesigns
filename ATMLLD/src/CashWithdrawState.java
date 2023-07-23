public class CashWithdrawState extends State{
    @Override
    public void cashWithdrawal(ATM atm, Card card,int withdrawAmount){

        if(atm.getAtmBalance() < withdrawAmount)
            exit("ATM has Insufficient Balance !!!");

        if(card.getAccount().getBalance() < withdrawAmount)
            exit("You have Insufficient Balance in your account !!!");

        card.getAccount().deductBalance(withdrawAmount);
        CashDispenser cashDispenser = new TwoThousandsNotesWithdraw(new FiveHundredNotesWithdraw(new OneHundredNotesWithdraw(null)));

        cashDispenser.withdraw(atm,withdrawAmount);
        atm.printCurrentATMStatus();
        exit("Withdraw Successfully !!!");
    }

}
