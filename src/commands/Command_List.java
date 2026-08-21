package commands;

import utils.Os_res;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.nio.*;
import java.io.IOException;

public class Command_List {

    public static void getCommands() {
        String [] commandList  =  {
                "-------------------------------",
                "help - help for commands",
                "exit - shut down OS",
                "echo - print any text",
                "date - current date",
                "time - current time",
                "ls - list directory",
                "clear - clear terminal ",
                "touch - create a txt file ",
                "-------------------------------",
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
    public static void touchCommand(String fileName) {
        Path path = Paths.get(Os_res.system_path + Os_res.os_path + fileName + ".txt");

        try {
            Files.createFile(path);
            System.out.println("file created");
        }
        catch (IOException e) {
            System.out.println("can't create file or already exist ");
        }

    }






}
