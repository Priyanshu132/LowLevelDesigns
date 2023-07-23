public class Account {
    private Long balance;

    public Account(long amount){
        balance = amount;
    }

    public void addBalance(long amount){
        balance += amount;
    }

    public void deductBalance(long amount){
        balance -= amount;
    }

    public Long getBalance() {
        return balance;
    }

    public void setBalance(Long balance) {
        this.balance = balance;
    }
}
