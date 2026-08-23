package commands;

import utils.Os_res;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.nio.file.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

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
                "pwd - display current directory",
                "mvf - move forward into a folder",
                "mvb - move backward into a folder",
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
    public static List<String> listDirectory() {
        List<String> dic = new ArrayList<>();
        Path path = Paths.get(Os_res.system_path+pwdCommand());
        try(Stream<Path> list=Files.list(path)){
            list.filter(Files::isDirectory)
                    .map(Path::getFileName).forEach(
                            fileName -> {
                                dic.add(fileName.toString());
                            });
        }catch (IOException e){
            e.printStackTrace();
        }
        return dic;
    }
    public static void lsCommand() {
        Path path = Paths.get(Os_res.system_path+pwdCommand());
        try(Stream<Path> list=Files.list(path)){
        list.map(p -> {
            if(Files.isDirectory(p)){
                return "[D] " + p.getFileName();
            }
            else{
                return "[F] " + p.getFileName();
            }
        }).forEach(System.out::println);

        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public static void clearCommand() {
        for (int i = 0; i < 150; i++) {
            System.out.println();
        }
    }

    public static String pwdCommand() {
        return Os_res.os_path;
    }
    public static void touchCommand(String fileName) {
        Path path = Paths.get(Os_res.system_path + pwdCommand() + fileName );

        try {
            Files.createFile(path);
            System.out.println("file created");
        }
        catch (IOException e) {
            System.out.println("can't create file or already exist ");
        }

    }

    public static void rmCommand(String fileName) {
        Path path = Paths.get(Os_res.system_path + pwdCommand() + fileName);

        try {
            if (!Objects.equals(fileName, "root")) {
            boolean isExist = Files.deleteIfExists(path);
                if (!isExist)
                    System.out.println("file does not exist");
                else
                    System.out.println("file has been deleted");
                }
            else{
                System.out.println("root can't be deleted");
            }

        }
        catch (IOException e) {
            System.out.println("can't delete this file");
        }
    }

    public static void mvfCommand(String fileName) {
        List<String> directories = listDirectory();

        for(int i=0;i<directories.size();i++) {
            if(directories.get(i).equals(fileName)){
                Os_res.os_path = Os_res.os_path + directories.get(i) + "/";
                return;
            }
        }
            System.out.println("folder does not exist");
    }
    public static void mvbCommand() {
        String[] current_paths = Os_res.os_path.split("/");
        if(current_paths.length > 1 ){
            StringBuilder updated_paths = new StringBuilder();

            for (int i = 0; i < current_paths.length - 1; i++) {
                updated_paths.append(current_paths[i]).append("/");
            }

            Os_res.os_path = updated_paths.toString();
        }
        else {
            System.out.println("no path exists");
        }
    }






}
