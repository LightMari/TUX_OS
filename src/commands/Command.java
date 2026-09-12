package commands;

import utils.Os_res;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public interface Command {
    void execute(String  cmd);
    public static List<String> listDirectory() {
        List<String> dic = new ArrayList<>();
        Path path = Paths.get(Os_res.system_path+Os_res.os_path);
        try(Stream<Path> list= Files.list(path)){
            list.filter(Files::isDirectory)
                    .map(Path::getFileName).forEach(
                            fileName -> {
                                dic.add(fileName.toString());
                            });
        }catch (IOException e){
            System.out.println("Input error reading file or folder");
        }
        return dic;
    }
}
