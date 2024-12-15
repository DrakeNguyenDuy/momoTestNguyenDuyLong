package momo.service;

import momo.model.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaymentService {

    private static PaymentService paymentService = null;
    private HashMap<Integer, Payment> payments = null;
    private int idSequence = 0;

    private PaymentService() {
    }

    public static PaymentService getInstance() {
        if (paymentService == null) {
            paymentService = new PaymentService();
            paymentService.payments = new HashMap<Integer, Payment>();
        }
        return paymentService;
    }

    public List<Payment> getPayments() {
        return new ArrayList<>(payments.values());
    }

    public void addPayment(Payment payment) {
        payments.put(payment.getId(), payment);
    }

    public void addPayments(List<Payment> payments) {
        for (Payment payment : payments) {
            addPayment(payment);
        }
    }

    public int getIdSequence() {
        return idSequence;
    }

    public void setIdSequence(int idSequence) {
        this.idSequence = idSequence;
    }

    public int nextIdSequence() {
        int nextId = idSequence++;
        setIdSequence(nextId);
        return nextId;
    }
}
