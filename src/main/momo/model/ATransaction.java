package momo.model;

public abstract class ATransaction {
    protected int id;
    protected long amount;
    protected String state;

    public ATransaction(int id, long amount, String state) {
        this.id = id;
        this.amount = amount;
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
