package commands;

public class Shell {

public String execute(String [] args) {


    switch (args[0]) {
        case "help":
            Command_List.getCommands();
            break;
        case "exit":
            return "exit";
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
            return Command_List.lsCommand();
        case "clear":
            return Command_List.clearCommand();
        default:
            return ("command not recognized \n");

    }

    return "";
}

}
