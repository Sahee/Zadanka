package pl.sahee;


public class Core {

    private static Core instnc;

    private double money;

    private Core() {
    }

    public static Core getInst() {
        if (instnc == null)
            instnc = new Core();

        return instnc;
    }

    public void addMoney(double moneyToBeAdded) {
        money += moneyToBeAdded;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
    public void substractMoney(double moneyToBeSubstracted) {
        money -= moneyToBeSubstracted;
    }
}

