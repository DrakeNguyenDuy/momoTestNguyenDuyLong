package momo.command;

public class ExceptionCommand implements ICommand {
    private static ExceptionCommand exceptionCommand = null;

    private ExceptionCommand() {
    }

    public static ExceptionCommand getInstance() {
        if (exceptionCommand == null) {
            exceptionCommand = new ExceptionCommand();
        }
        return exceptionCommand;
    }

    @Override
    public void execute(String[] params) {
        System.out.println("Command not found!");
    }
}
