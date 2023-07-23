public class User {
    private String name;

    private Account account;
    private Card card;

    public User(String name,Account account){
        this.account = account;
        this.name = name;
    }
    public User(String name,Account account,Card card){
        this.account = account;
        this.card = card;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }
}
