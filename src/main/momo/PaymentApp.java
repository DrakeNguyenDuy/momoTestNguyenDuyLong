package momo;

import momo.command.ICommand;
import momo.command.InvokerCommand;

import java.util.Scanner;

public class PaymentApp {
    public static void main(String[] args) {
        System.out.println("Welcome");
        Scanner scanner = new Scanner(System.in);
        String promt = null;
        ICommand command = null;
        while (true) {
            promt = scanner.nextLine();
            if(promt == null || promt.isEmpty())
            {
                continue;
            }
            command = InvokerCommand.getInstance().createCommand(promt);
            command.execute();
        }
    }

}
