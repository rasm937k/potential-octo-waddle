public class WashCard {
    private int cardID;
    private double money;
    private boolean adminStatus;

    public WashCard(int cardID, double money, boolean adminStatus){
        this.cardID = cardID;
        this.money = money;
        this.adminStatus = adminStatus;
    }

    public int getCardID() {
        return cardID;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public boolean isAdminStatus() {
        return adminStatus;
    }
}
