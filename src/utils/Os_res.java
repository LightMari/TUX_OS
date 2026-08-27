package utils;

import java.util.HashMap;

public class Os_res {
    public static String logo =
             "---------------------------------------------------\n" +
             "████████╗██╗   ██╗██╗  ██╗     ██████╗ ███████╗    \n" +
             "╚══██╔══╝██║   ██║╚██╗██╔╝    ██╔═══██╗██╔════╝    \n" +
             "   ██║   ██║   ██║ ╚███╔╝     ██║   ██║███████╗    \n" +
             "   ██║   ██║   ██║ ██╔██╗     ██║   ██║╚════██║    \n" +
             "   ██║   ╚██████╔╝██╔╝ ██╗    ╚██████╔╝███████║    \n" +
             "   ╚═╝    ╚═════╝ ╚═╝  ╚═╝     ╚═════╝ ╚══════╝    \n" +
             "---------------------------------------------------";
    public final static String  system_path = "/home/maries/Development/Java/TUX_OS/src/";
    public static String  os_path = "file_system/root/canvas/";
    public static HashMap<String,String> animals = new HashMap<>();
    public static HashMap<String,String> installedCommands = new HashMap<>();
    public static void bootAnimation() {
            String [] animations={
                    "Starting System.....",
                    "Starting System check.....",
                    "Starting Bootloader......",
                    "Checking Hardware.....",
                    "Checking Ram.....",
                    "Checking Kernel.....",
                    "Booting System process.....",
                    "Starting Device manager......",
                    "Starting Process Handler.....",
                    "Starting Services......",
                    "Booting OS......",
                    "Checking TUI......",
                    "Booting TUI......",
                    "Checking Screen......",
                    "Booting Screen......",
                    "Booting Logo......",
                    "Starting System......"
            };

            for(String animation:animations){
                try {
                    Thread.sleep(800);
                    System.out.println(animation);
                }
                catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("-----------------------------------------");
            set_animals();
            set_installed_commands();
    }
    public static void set_animals(){
        animals.put("cat","   |\\---/|\n" +
                "   | ,_, |\n" +
                "    \\_`_/-..----.\n" +
                " ___/ `   ' ,\"\"+ \\  sk\n" +
                "(__...'   __\\    |`.___.';\n" +
                "  (_,...'(_,.`__)/'.....+");
        animals.put("horse","           ,--,\n" +
                "     _ ___/ /\\|\n" +
                " ,;'( )__, )  ~\n" +
                "//  //   '--; \n" +
                "'   \\     | ^\n" +
                "     ^    ^");
        animals.put("fish","        O  o\n" +
                "          _\\_   o\n" +
                ">('>   \\\\/  o\\ .\n" +
                "       //\\___=\n" +
                "          ''");
        animals.put("spider"," ||  ||  \n" +
                " \\\\()// \n" +
                "//(__)\\\\\n" +
                "||    ||");
        animals.put("dino","             __\n" +
                "              / _)\n" +
                "     _/\\/\\/\\_/ /\n" +
                "   _|         /\n" +
                " _|  (  | (  |\n" +
                "/__.-'|_|--|_|");
    }



    public static void set_installed_commands(){
        installedCommands.put("help","This command used to display some commands in terminal\n" +
                "type 'help' :to see all commands \n" +
                "no 'args' in this command \n");
        installedCommands.put("echo","This command used to display given text to terminal\n" +
                "type 'echo *text*' :to print the text in the console \n" +
                "echo 'any text' : text args can have any text \n");
        installedCommands.put("date","This command used to display current system date \n" +
                "type 'date' *no args* :to print the current date from system \n" +
                "no 'args' in this command \n");
        installedCommands.put("time","This command used to display current system time \n" +
                "type 'time' *no args* :to print the current time from system \n" +
                "no 'args' in this command \n");
        installedCommands.put("ls","This command used to display current list of directory and files \n" +
                "type 'ls' *no args* :to print the list of current files and folders in format of [F] | [D] \n" +
                "no 'args' in this command \n");
        installedCommands.put("clear","This command used to clear all text in the terminal \n" +
                "type 'clear' *no args* : clear the terminal text  \n" +
                "no 'args' in this command \n");
         installedCommands.put("man","This command used to display the manual for the installed commands \n" +
                "type 'man' *command name* : manual of the command  \n" +
                "man 'command name' know more about the command \n");
         installedCommands.put("pwd","This command used to display present working directory \n" +
                "type 'pwd' *no args* : display current working directory \n" +
                "no 'args' returns a absolute path \n");
         installedCommands.put("mvf","This command used move into a directory \n" +
                "type 'mvf' *directory name* : move forward into a directory \n" +
                "mvf 'directory name' get into the given directory  \n");
         installedCommands.put("mvb","This command used move out of a directory \n" +
                "type 'mvb' *no args* : move back from directory \n" +
                "no 'args' get out from current directory  \n");
        installedCommands.put("touch","This command used create a new file \n" +
                "type 'touch' *file name .extension * : create a file  \n" +
                "touch 'filename works with extension'  \n");
        installedCommands.put("draw","This command draw an ascii art animal into the terminal \n" +
                "type 'draw' *animal name* : draw an animal  \n" +
                "draw 'animal name or r - random animal to display'  \n");

    }


}


