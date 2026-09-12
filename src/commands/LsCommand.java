package commands;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class LsCommand extends Command_Manual implements Command {
    String commandName;
    String commandManual;

    LsCommand() {
        this.commandName = "ls";
        this.commandManual = "TUX_OS COMMAND MANUAL\n" +
                "======================\n" +
                "\n" +
                "NAME\n" +
                commandName + "\n" +
                "\n" +
                "DESCRIPTION\n" +
                " Print any you type.\n" +
                "\n" +
                "USAGE\n" +
                commandName +" <your text>\n" +
                "\n" +
                "ARGUMENTS\n" +
                "< text >\n" +
                "Any Text or sentence or String.";;
    }

    @Override
    public void execute(String cmd) {

        Path path = Paths.get(cmd);
        try(Stream<Path> list= Files.list(path)){
            list.map(p -> {
                if(Files.isDirectory(p)){
                    return "[D] " + p.getFileName();
                }
                else{
                    return "[F] " + p.getFileName();
                }
            }).forEach(System.out::println);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    @Override
    public String info(){
        return commandManual;
    }
}
