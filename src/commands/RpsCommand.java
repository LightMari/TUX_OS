package commands;

import apps.RockPaperScissor;
import apps.calculator;
import process.ProcessManager;
import utils.Os_res;

public class RpsCommand extends Command_Manual implements Command{

    public String commandName;
    String commandManual;
    public RpsCommand() {

        commandName = "rps";
        commandManual = "TUX_OS COMMAND MANUAL\n" +
                "======================\n" +
                "\n" +
                "NAME \n" +
                commandName+"Rock paper scissor Game"+ "\n" +
                "\n" +
                "DESCRIPTION\n" +
                "simple rock paper scissors game.\n" +
                "\n" +
                "USAGE\n" +
                commandName +" <no args>\n" +
                "\n" +
                "ARGUMENTS\n" +
                "<no args\n" +
                "simple game ";
    }


    @Override
    public  void execute(String fileName) {

        System.out.println("Rock paper scissor Game Started");

        if(Os_res.rpsG==null){
            Os_res.rpsG = new RockPaperScissor();
            Os_res.rpsG.start();
            Os_res.rpsG.setName("RPS Game");
            ProcessManager.processes.add(Os_res.rpsG);
        }
        else {
            System.out.println("Rock paper scissor Game Running");
        }


    }
    @Override
    public String info(){
        return commandManual;
    }

}

