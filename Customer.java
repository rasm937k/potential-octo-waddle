public class Customer {
    private String name;
    private WashCard washCard;
    private double cardBalance;

    public Customer(String name, WashCard washCard, double cardBalance) {
        this.name = name;
        this.washCard = washCard;
        this.cardBalance = cardBalance;
    }


    public String getName() {
        return name;
    }
}
