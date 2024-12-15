package momo.command;

public class ExceptionCommand  implements ICommand {

    @Override
    public void execute() {
        System.out.println("Command not found!");
    }
}
