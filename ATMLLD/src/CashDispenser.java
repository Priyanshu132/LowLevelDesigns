public abstract class CashDispenser {

    CashDispenser nextCashDispenser;

    public CashDispenser(CashDispenser cashDispenser){
        this.nextCashDispenser = cashDispenser;
    }

    public void withdraw(ATM atm,int amount){

        if(nextCashDispenser != null){
            nextCashDispenser.withdraw(atm,amount);
        }
    }
}
