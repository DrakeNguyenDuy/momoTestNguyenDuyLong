package momo.service;

import momo.constant.MessageConstant;
import momo.model.Customer;

public class CustomerService {
    private static CustomerService customerService = null;
    private Customer customer = null;
    private final int INT_DEFAULT = 0;

    private CustomerService() {
        customer = new Customer();
    }

    public static CustomerService getInstance() {
        if (customerService == null) {
            customerService = new CustomerService();
        }
        return customerService;
    }

    public Customer getCustomer() {
        return customer;
    }

    /*
     * Cash in
     */
    public void cashIn(Customer customer, String[] command) {
        long amount = INT_DEFAULT;
        int COMMAND_FORMAT_CORRECT = 2;
        if (command.length != COMMAND_FORMAT_CORRECT) {
            System.out.println(MessageConstant.COMMAND_FORMAT_INCORRECT);
            return;
        }
        try {
            amount = Long.parseLong(command[1]);
        } catch (NumberFormatException e) {
            System.out.println(MessageConstant.CASH_IN_NAN);
            return;
        }

        if (amount <= INT_DEFAULT) {
            System.out.println(MessageConstant.CASH_IN_EQUAL_OR_SMALLER_O);
            return;
        }
        if (customer != null) {
            customer.setBalance(customer.getBalance() + amount);
            System.out.println("Your available balance: " + customer.getBalance());
        }
    }
}
