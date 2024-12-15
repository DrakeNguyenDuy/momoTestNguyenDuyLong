package momo.model;

public class Bill extends ATransaction {
    private String type;
    private String dueDate;
    private String provider;

    public Bill(int id, long amount, String state, String type, String dueDate, String provider) {
        super(id, amount, state);
        this.type = type;
        this.dueDate = dueDate;
        this.provider = provider;
    }

    public String getType() {
        return type;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getProvider() {
        return provider;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }
}
