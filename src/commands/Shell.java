package commands;

public class Shell {

public void execute(String [] args) {


    switch (args[0]) {
        case "help":
            Command_List.getCommands();
            break;
        case "echo":
            Command_List.EchoCommand(args);
            break;
        case "time":
            Command_List.TimeCommand();
            break;
        case "date":
            Command_List.DateCommand();
            break;
        case "ls":
            Command_List.lsCommand();
            break;
        case "clear":
            Command_List.clearCommand();
            break;
        case "touch":
            Command_List.touchCommand(args[1]);
            break;
        case "pwd":
            System.out.println(Command_List.pwdCommand());
        break;
        case "rm":
            Command_List.rmCommand(args[1]);
            break;
        case "mvf":
            Command_List.mvfCommand(args[1]);
            break;
        case "mvb":
            Command_List.mvbCommand();
            break;
        case "draw":
            Command_List.drawCommand(args[1]);
            break;
        default:
            System.out.println("command not recognized");

    }

}

}
