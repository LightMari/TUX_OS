package commands;

import utils.Os_res;

public class CalCommand extends Command_Manual implements Command{
    public String commandName;
    String commandManual;
    CalCommand() {

        commandName = "cal";
        commandManual = "TUX_OS COMMAND MANUAL\n" +
                "======================\n" +
                "\n" +
                "NAME \n" +
                commandName+"calculator"+ "\n" +
                "\n" +
                "DESCRIPTION\n" +
                "simple calculator.\n" +
                "\n" +
                "USAGE\n" +
                commandName +" <no args>\n" +
                "\n" +
                "ARGUMENTS\n" +
                "<no args\n" +
                "simple calculator";
    }


    @Override
    public void execute(String fileName) {

        if(Os_res.calculator==null || !Os_res.calculator.isAlive()){
            Os_res.calculator = new Calculator();
            Os_res.calculator.start();
        }
        else{
            System.out.println("already cal is RUNNING");
        }

    }
    @Override
    public String info(){
        return commandManual;
    }

}
