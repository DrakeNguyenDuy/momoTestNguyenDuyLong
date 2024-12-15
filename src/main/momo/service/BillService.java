package momo.service;

import momo.model.Bill;

import java.util.ArrayList;
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
}
