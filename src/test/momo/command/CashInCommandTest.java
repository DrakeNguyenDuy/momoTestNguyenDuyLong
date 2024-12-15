package momo.command;

import momo.constant.MessageConstant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CashInCommandTest {

    private static ByteArrayOutputStream outputStream;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
    }

    @Test
    public void testExitCommand_Success() throws Exception {
        String promt = "CASH_IN 10000";
        String[] commandArrays = promt.split(" ");
        ICommand command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        String output = outputStream.toString().trim();
        assertEquals("Your available balance: 10000", output);
        outputStream.reset();

        promt = "CASH_IN 20000";
        commandArrays = promt.split(" ");
        command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        output = outputStream.toString().trim();
        assertEquals("Your available balance: 30000", output);
        outputStream.reset();

        promt = "CASH_IN 50000      ";
        commandArrays = promt.split(" ");
        command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        output = outputStream.toString().trim();
        assertEquals("Your available balance: 80000", output);
        outputStream.reset();
    }

    @Test
    public void testExitCommand_EqualOrSmaller0() throws Exception {
        String promt = "CASH_IN 0";
        String[] commandArrays = promt.split(" ");
        ICommand command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        String output = outputStream.toString().trim();
        assertEquals(MessageConstant.CASH_IN_EQUAL_OR_SMALLER_O, output);
        outputStream.reset();

        promt = "CASH_IN -2000";
        commandArrays = promt.split(" ");
        command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        output = outputStream.toString().trim();
        assertEquals(MessageConstant.CASH_IN_EQUAL_OR_SMALLER_O, output);
        outputStream.reset();
    }

    @Test
    public void testExitCommand_NotANumber() throws Exception {
        String promt = "CASH_IN abc";
        String[] commandArrays = promt.split(" ");
        ICommand command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        String output = outputStream.toString().trim();
        assertEquals(MessageConstant.CASH_IN_NAN, output);
        outputStream.reset();

        promt = "CASH_IN abc ";
        commandArrays = promt.split(" ");
        command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        output = outputStream.toString().trim();
        assertEquals(MessageConstant.CASH_IN_NAN, output);
        outputStream.reset();
    }

    @Test
    public void testExitCommand_CommandFormatIncorrect() throws Exception {
        String promt = "CASH_IN ";
        String[] commandArrays = promt.split(" ");
        ICommand command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        String output = outputStream.toString().trim();
        assertEquals(MessageConstant.COMMAND_FORMAT_INCORRECT, output);
        outputStream.reset();

        promt = "CASH_IN";
        commandArrays = promt.split(" ");
        command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        output = outputStream.toString().trim();
        assertEquals(MessageConstant.COMMAND_FORMAT_INCORRECT, output);
        outputStream.reset();
    }
}
