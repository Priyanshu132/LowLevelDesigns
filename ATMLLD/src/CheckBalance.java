public class CheckBalance extends State{

    @Override
    public void checkBalance(ATM atm, Card card){

        System.out.println("BALANCE : " + card.getAccount().getBalance());
        atm.setCurrentState(new HasCardState());
    }
}
