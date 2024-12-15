package momo.command;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ListBillCommandTest {
    private static ByteArrayOutputStream outputStream;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }

    @Test
    public void testExitCommand_Success() throws Exception {
        String promt = "LIST_BILL";
        String[] commandArrays = promt.split(" ");
        ICommand command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        String output = outputStream.toString().trim();

        assertTrue(output.contains("ELECTRIC"));
        assertTrue(output.contains("WATER"));
        assertTrue(output.contains("INTERNET"));

        assertTrue(output.contains("Bill No."));
        assertTrue(output.contains("Due Date"));
        outputStream.reset();
    }
}
