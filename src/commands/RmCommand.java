package commands;

import utils.Os_res;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

public class RmCommand extends Command_Manual implements Command{
    String commandName;
    String commandManual;

    RmCommand() {
        commandName = "rm";
        commandManual = "TUX_OS COMMAND MANUAL\n" +
                "======================\n" +
                "\n" +
                "NAME\n" +
                commandName + "\n" +
                "\n" +
                "DESCRIPTION\n" +
                " Remove a file or folder.\n" +
                "\n" +
                "USAGE\n" +
                commandName +" <filename.extension or folder name >\n" +
                "\n" +
                "ARGUMENTS\n" +
                "<filename.extension or folder name>\n" +
                "Remove a file  or folder ";
    }


    @Override
    public void execute(String fileName) {
        Path path = Paths.get(Os_res.system_path + Os_res.os_path + fileName);

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
    @Override
    public String info(){
        return commandManual;
    }

}
