package commands;

import process.ProcessManager;

import javax.swing.*;

public class KillCommand extends Command_Manual implements Command{
    String commandName;
    String commandManual;

    KillCommand() {
        commandName = "kill";
        commandManual = "TUX_OS COMMAND MANUAL\n" +
                "======================\n" +
                "\n" +
                "NAME  \n" +
                commandName +"(Process Manager)"+ "\n" +
                "\n" +
                "DESCRIPTION\n" +
                "Kill or stop the running Process.\n" +
                "\n" +
                "USAGE\n" +
                commandName +" <Process ID>\n" +
                "\n" +
                "ARGUMENTS\n" +
                "<Process ID>\n" +
                "Kill the running Process.";
    }


    @Override
    public void execute(String processID) {
        try {
        ProcessManager.killProcess(Integer.parseInt(processID));
        }
        catch (NumberFormatException e){
            System.out.println("Please enter a Process ID");
        }
    }

    @Override
    public String info(){
        return commandManual;
    }


}
