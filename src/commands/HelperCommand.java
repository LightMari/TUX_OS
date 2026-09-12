package commands;

import utils.Os_res;

import java.util.Objects;

public class HelperCommand extends Command_Manual implements Command {
    String commandName;
    String commandManual;

    HelperCommand() {
        commandName = "helper";
        commandManual = "TUX_OS COMMAND MANUAL\n" +
                "======================\n" +
                "\n" +
                "NAME\n" +
                commandName + "\n" +
                "\n" +
                "DESCRIPTION\n" +
                " Display the command manual.\n" +
                "\n" +
                "USAGE\n" +
                commandName +" <command name>\n" +
                "\n" +
                "ARGUMENTS\n" +
                "<command name>\n" +
                "display command manuals";
    }


    @Override
    public void execute(String command_name) {
            if(Os_res.installedCommands.get(command_name) != null){
                System.out.println("\n"+Os_res.installedCommands.get(command_name));
            }
            else{
                System.out.println("No command manual found");
            }
    }

    @Override
    public String info(){
        return commandManual;
    }


}
