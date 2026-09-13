package commands;

import utils.Os_res;

public class PsCommand extends Command_Manual implements Command{

    String commandName;
    String commandManual;

    PsCommand() {
        commandName = "ps";
        commandManual = "TUX_OS COMMAND MANUAL\n" +
                "======================\n" +
                "\n" +
                "NAME  \n" +
                commandName +"(Process Manager)"+ "\n" +
                "\n" +
                "DESCRIPTION\n" +
                "List the running Process.\n" +
                "\n" +
                "USAGE\n" +
                commandName +" <no args needed>\n" +
                "\n" +
                "ARGUMENTS\n" +
                "<no args needed>\n" +
                "List the running Process.";
    }


    @Override
    public void execute(String fileName) {
        try {
        if(Os_res.calculator !=null && Os_res.calculator.isAlive()){
            System.out.println("Process ID |Process Name | Process State ");
            System.out.println(Os_res.calculator.threadId()+"|\t"+Os_res.calculator.getName()+"|\t RUNNING");
        }
        else{
            System.out.println("No Process are Running.");
        }

        }
        catch (Exception e){
            System.out.println("Error:"+e.getMessage());
        }

    }

    @Override
    public String info(){
        return commandManual;
    }




}
