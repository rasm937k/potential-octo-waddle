public class WashCard {
    private int cardID;

    private int money;

    private boolean adminStatus;

    public WashCard(int cardID, int money, boolean adminStatus){
        this.cardID = cardID;
        this.money = money;
        this.adminStatus = adminStatus;
    }

    public int getCardID() {
        return cardID;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public boolean isAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(boolean adminStatus) {
        this.adminStatus = adminStatus;
    }
}
