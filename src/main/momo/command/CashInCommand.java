package momo.command;

import momo.model.Customer;
import momo.service.CustomerService;

public class CashInCommand implements ICommand {
    public static CashInCommand cashInCommand = null;
    public static final String TYPE = "CASH_IN";

    private CashInCommand() {
    }

    public static CashInCommand getInstance() {
        if (cashInCommand == null) {
            cashInCommand = new CashInCommand();
        }
        return cashInCommand;
    }

    @Override
    public void execute(String[] params) {
        Customer customer = CustomerService.getInstance().getCustomer();
        CustomerService.getInstance().cashIn(customer, params);
    }
}
