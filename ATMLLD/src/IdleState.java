public class IdleState extends State{

    public void insertCard(ATM atm, Card card){
        System.out.println("Card Is Inserted Successfully !!!");
        atm.setCurrentState(new HasCardState());
    }
}
