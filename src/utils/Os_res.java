package utils;

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

    }
}
