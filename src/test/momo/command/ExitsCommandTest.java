package momo.command;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class ExitsCommandTest{

    private static ByteArrayOutputStream outputStream;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }

    @Test
    public void testExitCommand()
    {
        String promt = "EXIT";
        ICommand command = InvokerCommand.getInstance().createCommand(promt);
        command.execute();
        String output = outputStream.toString().trim();
        assertEquals("Good bye!", output);
        outputStream.reset();
    }

    @Test
    public void testUpperCaseLowerCase()
    {
        //Upper case
        String promt = "EXIT";
        ICommand command = InvokerCommand.getInstance().createCommand(promt);
        command.execute();
        String output = outputStream.toString().trim();
        assertEquals("Good bye!", output);
        outputStream.reset();

        //Lower case
        promt = "exit";
        command = InvokerCommand.getInstance().createCommand(promt);
        command.execute();
        output = outputStream.toString().trim();
        assertEquals("Good bye!", output);
        outputStream.reset();

        //Mixer case
        promt = "eXIt";
        command = InvokerCommand.getInstance().createCommand(promt);
        command.execute();
        output = outputStream.toString().trim();
        assertEquals("Good bye!", output);
        outputStream.reset();
    }
}
