public class ATMRoom {

    ATM atm;
    User user;

    public void startATM() {

        initilize();

        atm.printCurrentATMStatus();
        atm.getCurrentState().insertCard(atm,user.getCard());
        atm.getCurrentState().authenticateCard(atm,user.getCard());
        atm.getCurrentState().authenticatePin(atm,user.getCard(),561258);
        atm.getCurrentState().selectOperation(atm,user.getCard(),TransactionType.CASH_WITHDRAW);
        atm.getCurrentState().cashWithdrawal(atm,user.getCard(),8600);
        atm.printCurrentATMStatus();

    }

    private void initilize() {
        Account account = new Account(100000);
        Card card = new Card(account,411,12,2025,561258);
        user = new User("Priyanshu Gupta",account,card);
        atm = new ATM(new IdleState(),5,5,5);
    }

}
