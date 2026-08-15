package commands;

public class Command_List {

    public static void getCommand() {
        String [] commandList  =  {
                "help > help for commands",
                "exit > shut down OS",
                "echo > print any text",
        };
        for (String command : commandList) {
            System.out.println(command);
        }


    }

}
