package commands;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;

public class Command_List {

    public static void getCommands() {
        String [] commandList  =  {
                "help - help for commands",
                "exit - shut down OS",
                "echo - print any text",
                "date - current date",
                "time - current time",
                "ls - list directory",
                "clear - clear terminal ",
        };
        for (String command : commandList) {
            System.out.println(command);
        }
    }
    public static void EchoCommand(String [] cmds) {
        for(int i =1; i< cmds.length;i++) {
            System.out.print(cmds[i]+ " ");
        }
        System.out.println();
    }
    public static void DateCommand() {
        LocalDate date =  LocalDate.now();
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println(date.format(formattedDate));
    }
    public static void TimeCommand() {
        LocalTime time =  LocalTime.now();
        System.out.println(time);
    }
    public static String lsCommand() {
        return "user/ \n";
    }
    public static String clearCommand() {
        return "clear \n";
    }





}
