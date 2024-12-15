package momo.command;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class InvokerCommandTest {

    @Test
    public void testCreateCommand()
    {
        String command = "EXIT";
        String[] commandArrays = command.split(" ");
        ICommand cmd = InvokerCommand.getInstance().createCommand(commandArrays);
        assertEquals(ExitsCommand.class, cmd.getClass());

        command = "RUN 2 3";
        commandArrays = command.split(" ");
        cmd = InvokerCommand.getInstance().createCommand(commandArrays);
        assertEquals(ExceptionCommand.class, cmd.getClass());

        command = "CASH_IN 2";
        commandArrays = command.split(" ");
        cmd = InvokerCommand.getInstance().createCommand(commandArrays);
        assertEquals(CashInCommand.class, cmd.getClass());
    }
}
