package momo.command;

import momo.model.Bill;
import momo.service.BillService;
import momo.service.CustomerService;
import momo.service.PaymentService;

import java.util.List;

public class ListBillCommand implements ICommand {
    private static ListBillCommand instance = null;
    public static final String TYPE = "LIST_BILL";

    public static ListBillCommand getInstance() {
        if (instance == null) {
            instance = new ListBillCommand();
        }
        return instance;
    }

    @Override
    public void execute(String[] params) {
        BillService billService = BillService.getInstance();
        List<Bill> bills = billService.getBills();
        System.out.printf("%-10s %-10s %-10s %-15s %-10s %-15s%n",
                "Bill No.", "Type", "Amount", "Due Date", "State", "PROVIDER");
        for (Bill bill : bills) {
            System.out.printf("%-10d %-10s %-10d %-15s %-10s %-15s%n",
                    bill.getId(), bill.getType(), bill.getAmount(), bill.getDueDate(), bill.getState(), bill.getProvider());
        }
    }
}
