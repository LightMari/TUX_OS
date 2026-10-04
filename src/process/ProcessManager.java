package process;

import java.util.ArrayList;

public class ProcessManager {
    public static ArrayList<Thread> processes=new ArrayList<>();
    public static void showProcesses(){
       if(!processes.isEmpty()){
        for(Thread process:processes){
            System.out.println("process name: "+process.getName()+" Process ID: "+process.threadId());
        }
       }
       else System.out.println("No processes found");
    }

    public static void killProcess(int processId){
        if(!processes.isEmpty()){
            for(Thread process:processes){
                if(process.threadId()==processId){
                    process.interrupt();
                    processes.remove(process);
                    return;
                }
            }
        }
        else System.out.println("No processes found");

    }

}
