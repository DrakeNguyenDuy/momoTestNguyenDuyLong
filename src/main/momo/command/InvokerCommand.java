package momo.command;

public class InvokerCommand {
    private static InvokerCommand invokerCommand = null;

    public static InvokerCommand getInstance() {
        if (invokerCommand == null) {
            invokerCommand = new InvokerCommand();
        }
        return invokerCommand;
    }

    public ICommand createCommand(String[] commandArrays) {
        String command = commandArrays[0].toUpperCase();
        return switch (command) {
            case ExitsCommand.TYPE -> ExitsCommand.getInstance();
            case CashInCommand.TYPE -> CashInCommand.getInstance();
            case ListBillCommand.TYPE -> ListBillCommand.getInstance();
            default -> ExceptionCommand.getInstance();
        };
    }
}
