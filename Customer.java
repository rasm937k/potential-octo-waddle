public class Customer {
    private String name;
    private WashCard washCard;
    private int cardBalance;

    public Customer(String name, WashCard washCard, int cardBalance) {
        this.name = name;
        this.washCard = washCard;
        this.cardBalance = cardBalance;
    }


    public String getName() {
        return name;
    }

    public int getCardBalance() {
        return cardBalance;
    }

    public WashCard getWashCard() {
        return washCard;
    }
}
