package commands;
import apps.calculator;
import process.ProcessManager;
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


        if(Os_res.cal==null){
            System.out.println("calculator called");
            Os_res.cal = new calculator();
            Os_res.cal.start();
            Os_res.cal.setName("Calculator");
            ProcessManager.processes.add(Os_res.cal);
        }
        else{
            System.out.println("already calculator is RUNNING");
       }

    }
    @Override
    public String info(){
        return commandManual;
    }

}
