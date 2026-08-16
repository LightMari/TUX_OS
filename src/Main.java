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
            cmd_command = cmd_scanner.nextLine().toLowerCase();
            String [] cmd = cmd_command.split(" ");

            if(cmd[0].equals("help")) {
                Command_List.getCommands();
            } else if (cmd[0].equals("exit")) {
                break;
            } else if (cmd[0].equals("echo")) {
               Command_List.EchoCommand(cmd);
            } else if (cmd[0].equals("date")) {
                Command_List.DateCommand();
            } else if (cmd[0].equals("time")) {
                Command_List.TimeCommand();
            } else{
                System.out.println("command not recognized");
            }

        }
    }


}
