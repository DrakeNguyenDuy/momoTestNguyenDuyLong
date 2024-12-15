package momo.command;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionCommandTest {

    private static ByteArrayOutputStream outputStream;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }

    @Test
    public void testExceptionCommand()
    {
        String promt = "CMD 2 3";
        String[] commandArrays = promt.split(" ");
        ICommand command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        String output = outputStream.toString().trim();
        assertEquals("Command not found!", output);
        outputStream.reset();
    }

}
