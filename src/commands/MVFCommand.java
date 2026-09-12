package commands;

import utils.Os_res;

import java.util.List;

public class MVFCommand extends Command_Manual implements Command {
    public String commandName;
    String commandManual;

    MVFCommand() {
        commandName = "mvf";
        commandManual = "TUX_OS COMMAND MANUAL\n" +
                "======================\n" +
                "\n" +
                "NAME \n" +
                commandName+"(Move Forward)"+ "\n" +
                "\n" +
                "DESCRIPTION\n" +
                "move into a directory.\n" +
                "\n" +
                "USAGE\n" +
                commandName +" <folder name or directory name>\n" +
                "\n" +
                "ARGUMENTS\n" +
                "<folder name or directory name>\n" +
                "move into a directory";
    }


    @Override
    public void execute(String fileName) {
        List<String> directories = Command.listDirectory();

        for(int i=0;i<directories.size();i++) {
            if(directories.get(i).equals(fileName)){
                Os_res.os_path = Os_res.os_path + directories.get(i) + "/";
                return;
            }
        }
        System.out.println("folder does not exist");
    }
    @Override
    public String info(){
        return commandManual;
    }

}
