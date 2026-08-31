package commands;

import file_system.root.canvas.programs.Nano_TE;
import utils.Os_res;

import java.io.File;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.chrono.ChronoLocalDateTime;
import java.time.format.DateTimeFormatter;
import java.nio.file.*;
import java.io.IOException;
import java.util.*;
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
                "draw - display an ascii art animal",
                "man - display the manual for command",
                "cat - display the text from a file",
                "nano - enter text editor",

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
    public static void drawCommand(String animal_Name) {
        if(!Objects.equals(animal_Name, "r")){
            if(Os_res.animals.get(animal_Name) != null)
            System.out.println("\n"+Os_res.animals.get(animal_Name)+"\n");
            else
                System.out.println("  _____                                    _                           _   _ \n" +
                        "  \\_   \\_ __   ___ ___  _ __ _ __ ___  ___| |_  __      _____  _ __ __| | / \\\n" +
                        "   / /\\/ '_ \\ / __/ _ \\| '__| '__/ _ \\/ __| __| \\ \\ /\\ / / _ \\| '__/ _` |/  /\n" +
                        "/\\/ /_ | | | | (_| (_) | |  | | |  __/ (__| |_   \\ V  V / (_) | | | (_| /\\_/ \n" +
                        "\\____/ |_| |_|\\___\\___/|_|  |_|  \\___|\\___|\\__|   \\_/\\_/ \\___/|_|  \\__,_\\/   \n");
        }
        else{
            String[] animals = Os_res.animals.keySet().toArray(new String[0]);
            int animal_len =  Os_res.animals.size();
            Random rand_gen = new Random();
            System.out.println("\n"+Os_res.animals.get(animals[rand_gen.nextInt(0,animal_len)])+"\n");
        }

    }
    public static void manCommand(String command_name) {
        if(!Objects.equals(command_name, "")){
            if(Os_res.installedCommands.get(command_name) != null){
                System.out.println("\n"+Os_res.installedCommands.get(command_name));
            }
            else{
                System.out.println("  _____                                    _                           _   _ \n" +
                        "  \\_   \\_ __   ___ ___  _ __ _ __ ___  ___| |_  __      _____  _ __ __| | / \\\n" +
                        "   / /\\/ '_ \\ / __/ _ \\| '__| '__/ _ \\/ __| __| \\ \\ /\\ / / _ \\| '__/ _` |/  /\n" +
                        "/\\/ /_ | | | | (_| (_) | |  | | |  __/ (__| |_   \\ V  V / (_) | | | (_| /\\_/ \n" +
                        "\\____/ |_| |_|\\___\\___/|_|  |_|  \\___|\\___|\\__|   \\_/\\_/ \\___/|_|  \\__,_\\/   \n");
            }
        }

    }
    public static void nanosCommand(String file_name) {
        Nano_TE textEditor = new Nano_TE();
        if(!Objects.equals(file_name, "n")) {
            textEditor.openFile(Os_res.system_path+pwdCommand() + "/" + file_name);
        }
        else {
            touchCommand("untitled.txt");
            textEditor.openFile(Os_res.system_path+pwdCommand()+"/untitled.txt");
        }
    }

    public static void catCommand(String fileName) {
        Path path = Path.of(Os_res.system_path+pwdCommand()+fileName);
        if(!Objects.equals(fileName, "")) {
            try {
            System.out.println(Files.readString(path));
            }
            catch (IOException e) {
                System.out.println("no file exists");
            }
        }
        else {
            System.out.println("no file exists");
        }
    }


}
