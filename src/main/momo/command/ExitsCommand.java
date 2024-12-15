package momo.command;

public class ExitsCommand implements ICommand {
    private static ExitsCommand exitsCommand = null;

    private ExitsCommand() {
    }

    public static ExitsCommand getInstance() {
        if (exitsCommand == null) {
            exitsCommand = new ExitsCommand();
        }
        return exitsCommand;
    }

    public final static String TYPE = "EXIT";

    @Override
    public void execute(String[] params) {
        System.out.println("Good bye!");
    }
}
