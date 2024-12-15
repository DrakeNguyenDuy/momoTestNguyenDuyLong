package momo.command;

import momo.constant.MessageConstant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SearchProviderCommandTest {
    private static ByteArrayOutputStream outputStream;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }

    @Test
    public void testSearch_NotFound() throws Exception {
        String promt = "SEARCH_BILL_BY_PROVIDER ABC";
        String[] commandArrays = promt.split(" ");
        ICommand command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        String output = outputStream.toString().trim();

        assertEquals(MessageConstant.NOT_FOUND_BY_PROVIDER, output);
        outputStream.reset();
    }

    @Test
    public void testSearch_Success() throws Exception {
        String promt = "SEARCH_BILL_BY_PROVIDER VNPT";
        String[] commandArrays = promt.split(" ");
        ICommand command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        String output = outputStream.toString().trim();

        assertTrue(output.contains("VNPT"));
        assertTrue(output.contains("30/11/2020"));
        assertTrue(output.contains("INTERNET"));

        assertTrue(output.contains("Bill No."));
        assertTrue(output.contains("Due Date"));
        outputStream.reset();
    }

    @Test
    public void testSearch_CommandFormatIncorrect() throws Exception {
        String promt = "SEARCH_BILL_BY_PROVIDER";
        String[] commandArrays = promt.split(" ");
        ICommand command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        String output = outputStream.toString().trim();

        assertEquals(MessageConstant.COMMAND_FORMAT_INCORRECT, output);
        outputStream.reset();
    }
}
