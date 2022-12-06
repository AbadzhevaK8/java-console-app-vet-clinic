import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PetDataBase {

    static void save(ArrayList<Animal> pets) {
        File petsBase = new File("petsBase.txt");
        try {
            petsBase.createNewFile();
        } catch (IOException e) {
            System.out.println("Something get wrong.");
        }
        FileWriter fw = null;
        try {
            fw = new FileWriter((petsBase));
        } catch (IOException e) {
            System.out.println("Something get wrong.");
        }
        for (Animal p : pets) {
            String petStr = p.id + ";" + p.kind + ";" + p.sex + ";" + p.name + ";" + p.birthday + ";" + p.description + "\n";
            try {
                assert fw != null;
                fw.append(petStr);
                fw.flush();
            } catch (IOException e) {
                System.out.println("Something get wrong.");
            }
        }
    }


    static void load(ArrayList<Animal> pets) {
        pets.clear();
        try {
            File file = new File("petsBase.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] string = line.split(";");
                Animal pet = new Animal();
                pet.id = Integer.parseInt(string[0]);
                pet.kind = string[1];
                pet.sex = Sex.valueOf(string[2]);
                pet.name = string[3];
                try {
                    pet.birthday = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(string[4]);
                    //break;
                } catch (ParseException e) {
                    System.out.println("Invalid date format.");
                }
                pet.description = string[5];
                pets.add(pet);
                line = reader.readLine();
            }
        }  catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Something get wrong.");
        }
        System.out.println("Success!");
    }

}
