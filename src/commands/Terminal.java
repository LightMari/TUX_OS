package commands;
import java.util.Scanner;

public class Terminal {
    private static final Scanner cmd_scanner = new Scanner(System.in);
    static String  cmd_command = "";
    static String cmd ="home/user/ > ";
    static StringBuilder cmd_line = new StringBuilder(cmd);

    public static void start() {
        Shell shell = new Shell();
        System.out.println("home/user/ > type 'help' for commands ");
        while (true) {
            System.out.print(cmd_line.toString());
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
