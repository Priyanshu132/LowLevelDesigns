public class SelectOperationState extends State{

    @Override
    public void selectOperation(ATM atm, Card card,TransactionType txnType){

        if(txnType == TransactionType.CHECK_BALANCE){
            System.out.println("BALANCE : "+ card.getAccount().getBalance());
            atm.setCurrentState(new HasCardState());
        }
        else {
            atm.setCurrentState(new CashWithdrawState());
        }


    }

}
