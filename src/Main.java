import java.util.Scanner;
import commands.*;
public class Main {
private static Scanner cmd_scanner = new Scanner(System.in);
protected static String  cmd_command = "";
    public static void main(String[] args) {

        System.out.println("---------------------------------------------------\n" +
                           "████████╗██╗   ██╗██╗  ██╗     ██████╗ ███████╗    \n" +
                           "╚══██╔══╝██║   ██║╚██╗██╔╝    ██╔═══██╗██╔════╝    \n" +
                           "   ██║   ██║   ██║ ╚███╔╝     ██║   ██║███████╗    \n" +
                           "   ██║   ██║   ██║ ██╔██╗     ██║   ██║╚════██║    \n" +
                           "   ██║   ╚██████╔╝██╔╝ ██╗    ╚██████╔╝███████║    \n" +
                           "   ╚═╝    ╚═════╝ ╚═╝  ╚═╝     ╚═════╝ ╚══════╝    \n" +
                           "---------------------------------------------------"
        );

        System.out.println("os/home/user > type 'help' for commands ");
        while (true) {
            System.out.print("os/home/user > ");
            cmd_command = cmd_scanner.nextLine();
            if(cmd_command.equals("help")) {
                Command_List.getCommand();
            } else if (cmd_command.equals("exit")) {
                break;
            } else if (cmd_command.equals("echo")) {
                System.out.println("HELLO !!");
            }
            else{
                System.out.println("command not recognized");
            }

        }
    }


}
