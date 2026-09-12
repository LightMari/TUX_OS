package commands;

import utils.Os_res;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.Random;

public class DrawCommand extends Command_Manual implements Command{

    String commandName;
    String commandManual;

    DrawCommand() {
        commandName = "draw";
        commandManual = "TUX_OS COMMAND MANUAL\n" +
                "======================\n" +
                "\n" +
                "NAME\n" +
                commandName + "\n" +
                "\n" +
                "DESCRIPTION\n" +
                " Draw ascii animals art (cat,horse,fish,spider,dino).\n" +
                "\n" +
                "USAGE\n" +
                commandName +" <animal name or -r for random >\n" +
                "\n" +
                "ARGUMENTS\n" +
                "<animal name or -r for random>\n" +
                "Draw ascii animal art into terminal ";
        set_animals();
    }


    @Override
    public void execute(String animal_Name) {
        if(!Objects.equals(animal_Name, "-r")){
           getAnimal(animal_Name);
        }
        else{
            getAnimal();
        }
    }

    void getAnimal(){
        String[] animals = Os_res.animals.keySet().toArray(new String[0]);
        int animal_len =  Os_res.animals.size();
        Random rand_gen = new Random();
        System.out.println("\n"+Os_res.animals.get(animals[rand_gen.nextInt(0,animal_len)])+"\n");
    }

    void getAnimal(String animal_Name){
        if(Os_res.animals.get(animal_Name) != null)
            System.out.println("\n"+Os_res.animals.get(animal_Name)+"\n");
        else
            System.out.println("Invalid command argument");
    }

    public void set_animals(){
         Os_res.animals.put("cat","   |\\---/|\n" +
                "   | ,_, |\n" +
                "    \\_`_/-..----.\n" +
                " ___/ `   ' ,\"\"+ \\  sk\n" +
                "(__...'   __\\    |`.___.';\n" +
                "  (_,...'(_,.`__)/'.....+");
        Os_res.animals.put("horse","           ,--,\n" +
                "     _ ___/ /\\|\n" +
                " ,;'( )__, )  ~\n" +
                "//  //   '--; \n" +
                "'   \\     | ^\n" +
                "     ^    ^");
        Os_res.animals.put("fish","        O  o\n" +
                "          _\\_   o\n" +
                ">('>   \\\\/  o\\ .\n" +
                "       //\\___=\n" +
                "          ''");
        Os_res.animals.put("spider"," ||  ||  \n" +
                " \\\\()// \n" +
                "//(__)\\\\\n" +
                "||    ||");
        Os_res.animals.put("dino","             __\n" +
                "              / _)\n" +
                "     _/\\/\\/\\_/ /\n" +
                "   _|         /\n" +
                " _|  (  | (  |\n" +
                "/__.-'|_|--|_|");
    }

    @Override
    public String info(){
        return commandManual;
    }

}
