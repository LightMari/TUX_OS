package commands;

import utils.Os_res;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class TouchCommand extends Command_Manual implements Command {
    String commandName;
    String commandManual;

    TouchCommand() {
        commandName = "touch";
        commandManual = "TUX_OS COMMAND MANUAL\n" +
                "======================\n" +
                "\n" +
                "NAME\n" +
                commandName + "\n" +
                "\n" +
                "DESCRIPTION\n" +
                " Create a file.\n" +
                "\n" +
                "USAGE\n" +
                commandName +" <filename .extension>\n" +
                "\n" +
                "ARGUMENTS\n" +
                "<filename.extension>\n" +
                "Create a file with extension";
    }


    @Override
    public void execute(String fileName) {
        Path path = Paths.get(Os_res.system_path + Os_res.os_path + fileName );
        try {
            Files.createFile(path);
            System.out.println("file created");
        }
        catch (IOException e) {
            System.out.println("can't create file or already exist ");
        }

    }
    @Override
    public String info(){
        return commandManual;
    }

}
