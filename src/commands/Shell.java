package commands;

import utils.Os_res;

import java.util.Arrays;
import java.util.Objects;

public class Shell {

    EchoCommand echoCommand ;
    TouchCommand touchCommand;
    RmCommand rmCommand;
    LsCommand lsCommand;
    MVFCommand mvfCommand;
    MVBCommand mvbCommand;
    HelperCommand helperCommand;

    Shell(){
        echoCommand= new EchoCommand();
        touchCommand= new TouchCommand();
        rmCommand= new RmCommand();
        lsCommand= new LsCommand();
        mvfCommand= new MVFCommand();
        mvbCommand= new MVBCommand();
        helperCommand= new HelperCommand();

        Os_res.installedCommands.put(echoCommand.commandName, echoCommand.info());
        Os_res.installedCommands.put(touchCommand.commandName, touchCommand.info());
        Os_res.installedCommands.put(rmCommand.commandName, rmCommand.info());
        Os_res.installedCommands.put(lsCommand.commandName, lsCommand.info());
        Os_res.installedCommands.put(mvbCommand.commandName, mvbCommand.info());
        Os_res.installedCommands.put(mvfCommand.commandName, mvfCommand.info());
        Os_res.installedCommands.put(helperCommand.commandName, helperCommand.info());
    }
public void execute(String [] args) {

    switch (args[0]) {
        case "help":
            System.out.println(Os_res.installedCommands.keySet());
            break;
        case "echo":
            String input_cmd = "";
            for (int i = 1; i < args.length ; i++) {
                input_cmd = input_cmd .concat(args[i]+" ");
            }
            echoCommand.execute(input_cmd);
            break;
        case "touch":
           touchCommand.execute(args[1]);
            break;
        case "rm":
            rmCommand.execute(args[1]);
            break;
        case "ls":
            lsCommand.execute(Os_res.system_path+Os_res.os_path);
            break;
        case "mvf":
            lsCommand.execute(args[1]);
            break;
        case "mvb":
            mvbCommand.execute(Os_res.os_path);
            break;
        case "helper":
            helperCommand.execute(args[1]);
            break;
        default:
            System.out.println("command not recognized");

    }

}

}
