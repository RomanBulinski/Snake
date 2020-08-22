package Model;

public class Counter {

    private int amount;

    public Counter() {
        this.amount = 0;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Counter add(int i) {
        this.amount = amount+i;
        return this;
    }


}
