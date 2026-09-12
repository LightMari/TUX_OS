package commands;

public class EchoCommand extends Command_Manual implements  Command {
    String commandName;
    String commandManual;

    EchoCommand() {
        commandName = "echo";
        commandManual = "TUX_OS COMMAND MANUAL\n" +
                "======================\n" +
                "\n" +
                "NAME\n" +
                commandName + "\n" +
                "\n" +
                "DESCRIPTION\n" +
                " Print any you type.\n" +
                "\n" +
                "USAGE\n" +
                commandName +" <your text>\n" +
                "\n" +
                "ARGUMENTS\n" +
                "< text >\n" +
                "Any Text or sentence or String.";
    }


    @Override
    public void execute(String input_cmd) {
        System.out.println(input_cmd);
    }
    @Override
    public String info(){
        return commandManual;
    }
}
