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
    public static HashMap<String,String>acsii_animations = new HashMap<>();
    public static HashMap<String,String> installedCommands = new HashMap<>();
    public static void bootAnimation() {
            String [] animations={
                    "\\ Starting System.....",
                    "| Starting System check.....",
                    "- Starting Bootloader......",
                    "/ Checking Hardware.....",
                    "\\ Checking Ram.....",
                    "| Checking Kernel.....",
                    "- Booting System process.....",
                    "/ Starting Device manager......",
                    "\\ Starting Process Handler.....",
                    "| Starting Services......",
                    "- Booting OS......",
                    "/ Checking TUI......",
                    "\\ Booting TUI......",
                    "| Checking Screen......",
                    "- Booting Screen......",
                    "/ Booting Logo......",
                    "Starting System......"
            };

            for(String animation:animations){
                try {
                    Thread.sleep(500);
                    System.out.print("\r"+animation);
                }
                catch (InterruptedException e) {
                    System.out.println(e.getMessage());
                }
            }
            System.out.println("\n-----------------------------------------");
            set_animals();
            set_acsiiAnimations();
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


    public static void set_acsiiAnimations(){
            acsii_animations.put("dash","|,/,-,\\");
            acsii_animations.put("bounce","():::,:()::,::():,:::()");
            acsii_animations.put("worm","~-~-o,_/\\_o,~-~-o,_/\\_o");
            acsii_animations.put("faces","(.-.),(-_-),(.-.),(*_*)");
    }




}


