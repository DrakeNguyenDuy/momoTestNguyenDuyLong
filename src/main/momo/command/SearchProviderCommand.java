package momo.command;

import momo.service.BillService;

public class SearchProviderCommand implements  ICommand{
    private static SearchProviderCommand instance = null;
    public static final String TYPE = "SEARCH_BILL_BY_PROVIDER";

    public static SearchProviderCommand getInstance(){
        if(instance == null){
            instance = new SearchProviderCommand();
        }
        return instance;
    }

    @Override
    public void execute(String[] params) {
        BillService billService = BillService.getInstance();
        billService.findProvider(params);
    }
}
