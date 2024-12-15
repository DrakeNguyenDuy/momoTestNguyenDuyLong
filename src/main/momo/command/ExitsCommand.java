package momo.command;

public class ExitsCommand implements ICommand {
    public final static String TYPE = "EXIT";
    @Override
    public void execute() {
        System.out.println("Good bye!");
    }
}
