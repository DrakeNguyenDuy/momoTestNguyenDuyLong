package momo.command;

public class InvokerCommand {
    private static InvokerCommand invokerCommand = null;

    public static InvokerCommand getInstance() {
        if (invokerCommand == null) {
            invokerCommand = new InvokerCommand();
        }
        return invokerCommand;
    }


    public ICommand createCommand(String promt) {
        String[] commandArrays = promt.split(" ");
        String command = commandArrays[0].toUpperCase();
        switch (command) {
            case ExitsCommand.TYPE:
                return new ExitsCommand();
            default:
                return new ExceptionCommand();
        }

    }
}
