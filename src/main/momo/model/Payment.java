package momo.model;

public class Payment extends ATransaction {
    private String paymentDate;
    private int billId;

    public Payment(int id, long amount, String state, String paymentDate, int billId) {
        super(id, amount, state);
        this.paymentDate = paymentDate;
        this.billId = billId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public int getBillId() {
        return billId;
    }

    public void setBillId(int billId) {
        this.billId = billId;
    }
}
