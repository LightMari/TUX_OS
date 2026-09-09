package file_system.root.canvas.programs;

import commands.Command_List;
import utils.Os_res;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Nano_TE {
    Scanner textEditor_scanner = new Scanner(System.in);
    public void openFile(String filePath) {
        String  border = ".-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-.";
        String  contents="";
        Path path = Path.of(Os_res.system_path+ Command_List.pwdCommand() + "/" + filePath);
        System.out.println(border);

        try {
           Command_List.catCommand(filePath);
            System.out.println("Type something....");
            contents = textEditor_scanner.nextLine();
            Files.writeString(path,contents);
            System.out.println("file saved!!");

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }


    }

}
