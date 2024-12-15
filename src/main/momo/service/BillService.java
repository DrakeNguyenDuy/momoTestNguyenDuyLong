package momo.service;

import momo.constant.MessageConstant;
import momo.model.Bill;
import momo.model.Customer;
import momo.model.Payment;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class BillService {
    private static BillService billService = null;
    private HashMap<Integer, Bill> bills = null;

    private BillService() {
    }

    public static BillService getInstance() {
        if (billService == null) {
            billService = new BillService();
            billService.bills = new HashMap<Integer, Bill>();
            billService.bills.put(1, new Bill(1, 200000, "NOT_PAID", "ELECTRIC", "25/10/2020", "EVN HCMC"));
            billService.bills.put(2, new Bill(2, 175000, "NOT_PAID", "WATER", "30/10/2020", "SAVACO HCMC"));
            billService.bills.put(3, new Bill(3, 800000, "NOT_PAID", "INTERNET", "30/11/2020", "VNPT"));
        }
        return billService;
    }

    public void addBill(Bill bill) {
        bills.put(bill.getId(), bill);
    }

    public List<Bill> getBills() {
        return new ArrayList<Bill>(bills.values());
    }

    public void payment(String[] params) {
        if (params.length == 1) {
            System.out.println(MessageConstant.COMMAND_FORMAT_INCORRECT);
            return;
        }
        long totalAmount = 0;
        StringBuilder id = new StringBuilder();
        List<Payment> payments = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date currentDate = new Date();
        for (int i = 1; i < params.length; i++) {
            try {
                totalAmount += Long.parseLong(params[i]);
                if (i > 1) {
                    id.append(", ");
                }
                id.append(params[i]);
                Bill bill = bills.get(Integer.parseInt(params[i]));
                if(bill == null)
                {
                    System.out.println(MessageConstant.NOT_FOUND_BILL);
                    return;
                }
                payments.add(new Payment(PaymentService.getInstance().nextIdSequence(), bill.getAmount(), dateFormat.format(currentDate),
                        bill.getState(), bill.getId()));
            } catch (NumberFormatException e) {
                System.out.println(MessageConstant.CASH_IN_NAN);
                return;
            }
        }
        CustomerService customerService = CustomerService.getInstance();
        Customer customer = customerService.getCustomer();
        if (customer.getBalance() < totalAmount) {
            System.out.println(MessageConstant.BALANCE_NOT_ENOUGH);
            return;
        }

        System.out.println("Payment has been completed for Bill with id " + id.toString() + ".");
        PaymentService paymentService = PaymentService.getInstance();
        paymentService.addPayments(payments);
    }
}
