import java.util.concurrent.ThreadLocalRandom;

public class Card {
    private Long cardNumber;
    private Account account;

    private Integer CVV;

    private Integer expiryMonth;

    private Integer expiryYear;

    private Integer pin;

    public Card(Account account,Integer cvv,Integer expiryMonth,Integer expiryYear,Integer pin){
        this.account = account;
        this.pin = pin;
        this.CVV = cvv;
        this.expiryYear = expiryYear;
        this.expiryMonth = expiryMonth;
        generateCardNumber();
    }

    private void generateCardNumber() {
        long number = 0L;
        for(int i = 0 ;i < 16 ; i++)
            number = (number * 10) + ThreadLocalRandom.current().nextInt(0,10);
        cardNumber = number;
    }
    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public Integer getCVV() {
        return CVV;
    }

    public Integer getExpiryMonth() {
        return expiryMonth;
    }

    public Integer getExpiryYear() {
        return expiryYear;
    }

    public Integer getPin() {
        return pin;
    }

    public void setPin(Integer pin) {
        this.pin = pin;
    }
}
