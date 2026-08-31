package file_system.root.canvas.programs;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class Nano_TE {
    Scanner textEditor_scanner = new Scanner(System.in);
    public void openFile(String filePath) {
        String  border = ".-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-.";
        String  contents="";
        Path path = Path.of(filePath);
        System.out.println(border);

        try {
            System.out.println(Files.readString(path));
            System.out.println("Type something....");
            contents = textEditor_scanner.nextLine();
            Files.writeString(path,contents);
            System.out.println("file saved!!");

        }
        catch (IOException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }


    }

}
