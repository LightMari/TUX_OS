package commands;

import utils.Os_res;

public class MVBCommand extends Command_Manual implements Command{
    String commandName;
    String commandManual;

    MVBCommand() {
        commandName = "mvb";
        commandManual = "TUX_OS COMMAND MANUAL\n" +
                "======================\n" +
                "\n" +
                "NAME  \n" +
                commandName +"(Move Backward)"+ "\n" +
                "\n" +
                "DESCRIPTION\n" +
                "move out or back from a directory.\n" +
                "\n" +
                "USAGE\n" +
                commandName +" <no args needed>\n" +
                "\n" +
                "ARGUMENTS\n" +
                "<no args needed>\n" +
                "move out or back from a directory";
    }


    @Override
    public void execute(String fileName) {
        String[] current_paths = fileName.split("/");
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
    @Override
    public String info(){
        return commandManual;
    }


}
