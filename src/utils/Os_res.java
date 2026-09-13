package utils;

import commands.Calculator;

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
    //change the '/' in the code
    public final static String  system_path = "C:\\Users\\acer\\IdeaProjects\\TUX_OS\\src\\";
    public static String  os_path = "file_system\\root\\canvas\\";
    public static Calculator calculator;
    public static HashMap<String,String> animals = new HashMap<>();
    public static HashMap<String,String>acsii_animations = new HashMap<>();
    public static HashMap<String,String> installedCommands = new HashMap<>();
    public static void bootAnimation() {
            String [] animations={
                    "Starting System.",
                    "Starting System..",
                    "Starting System...",
                    "Starting System....",
                    "Starting System.....",
                    "Starting System.....",
                    "Starting System....",
                    "Starting System...",
                    "Starting System..",
                    "Starting System."
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

    }





}


