package momo.command;

import momo.constant.MessageConstant;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PayCommandTest {

    private static ByteArrayOutputStream outputStream;

    @BeforeAll
    public static void setUpBeforeClass() throws Exception {
        outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);
        String promt = "CASH_IN 1000000";
        String[] commandArrays = promt.split(" ");
        ICommand command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        outputStream.reset();
    }

    @Test
    public void testPay_Single_NotFound() throws Exception {
        String promt = "PAY 10";
        String[] commandArrays = promt.split(" ");
        ICommand command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        String output = outputStream.toString().trim();
        assertEquals(MessageConstant.NOT_FOUND_BILL, output);
        outputStream.reset();
    }

    @Test
    public void testPay_Single_Success() throws Exception {
        String promt = "PAY 1";
        String[] commandArrays = promt.split(" ");
        ICommand command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        String output = outputStream.toString().trim();
        assertEquals("Payment has been completed for Bill with id 1.", output);
        outputStream.reset();
    }

    @Test
    public void testPay_Multi_Success() throws Exception {
        String promt = "PAY 2 3";
        String[] commandArrays = promt.split(" ");
        ICommand command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        String output = outputStream.toString().trim();
        assertEquals("Payment has been completed for Bill with id 2, 3.", output);
        outputStream.reset();
    }

    @Test
    public void testPay_CommandFormatIncorrect() throws Exception {
        String promt = "PAY";
        String[] commandArrays = promt.split(" ");
        ICommand command = InvokerCommand.getInstance().createCommand(commandArrays);
        command.execute(commandArrays);
        String output = outputStream.toString().trim();
        assertEquals(MessageConstant.COMMAND_FORMAT_INCORRECT, output);
        outputStream.reset();
    }
}
