public abstract class State {

    public void insertCard(ATM atm, Card card){
        exit("OOPS!! Something went wrong");
    }

    public void authenticateCard(ATM atm, Card card){
        exit("OOPS!! Something went wrong");

    }
    public void selectOperation(ATM atm, Card card,TransactionType txnType){
        exit("OOPS!! Something went wrong");
    }



    public void authenticatePin(ATM atm, Card card,int pin){
        exit("OOPS!! Something went wrong");

    }

    public void cashWithdrawal(ATM atm, Card card,int withdrawAmount){
        exit("OOPS!! Something went wrong");

    }

    public void checkBalance(ATM atm, Card card){
        exit("OOPS!! Something went wrong");

    }

    public void returnCard(String message){
        System.out.println(message);
    }

    public void exit(String message){
        returnCard(message);
        System.out.println("Please Collect Your Card !!!");
        System.exit(0);
    }

}
