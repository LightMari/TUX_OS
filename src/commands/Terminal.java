package commands;
import utils.Os_res;

import java.util.Scanner;

public class Terminal {
    private static final Scanner cmd_scanner = new Scanner(System.in);
    static String  cmd_command = "";
    public static void start() {
        Shell shell = new Shell();
        System.out.println(Os_res.os_path + "> type 'help' for commands ");
        while (true) {
            System.out.print(Os_res.os_path + "> ");
            cmd_command = cmd_scanner.nextLine().toLowerCase();
            String [] cmd = cmd_command.split(" ");
            String result = shell.execute(cmd);

            if(result.equals("exit")) {
                break;
            }
            else {
                System.out.print(result);
            }


        }

    }

}
