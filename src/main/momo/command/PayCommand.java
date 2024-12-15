package momo.command;

import momo.service.BillService;

public class PayCommand implements  ICommand{
    private static PayCommand instance = null;
    public static final String TYPE = "PAY";

    public static PayCommand getInstance(){
        if(instance == null){
            instance = new PayCommand();
        }
        return instance;
    }

    @Override
    public void execute(String[] params) {
        BillService billService = BillService.getInstance();
        billService.payment(params);
    }
}
