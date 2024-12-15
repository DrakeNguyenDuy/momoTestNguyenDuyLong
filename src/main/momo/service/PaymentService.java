package momo.service;

import momo.model.Payment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PaymentService {

    private static PaymentService paymentService = null;
    private HashMap<Integer, Payment> payments = null;

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
}
