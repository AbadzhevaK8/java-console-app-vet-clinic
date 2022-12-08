import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class PetDataBase {

    static Animal getPetById(int petId, ArrayList<Animal> pets) {
        for (Animal p : pets) {
            if (p.id == petId) {
                return p;
            } else {
                System.out.println("Id not found. Please, repeat the command with the correct pet id.");
            }
        }
        return null;
    }

    static int petIdChecker() {
        int basicId = 0;
        try {
            File file = new File("petsBase.txt");
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] string = line.split(";");
                basicId = Integer.parseInt(string[0]);
                line = reader.readLine();
            }
            fr.close();
            reader.close();
        } catch (IOException e) {
            return basicId;
        }
        return basicId;
    }

    @SuppressWarnings("ResultOFMethodCallIgnored")
    static void save(ArrayList<Animal> pets) {
        System.out.println("CONGRATULATIONS! You have just rewritten the entire database."); // TODO think about preload DB.
        File petsBase = new File("petsBase.txt");
        try {
            petsBase.createNewFile();

            FileWriter fw = new FileWriter((petsBase));

            for (Animal p : pets) {
                String petStr = p.id + ";" + p.kind + ";" + p.sex + ";" + p.name + ";" + p.birthday + ";" + p.description + "\n";
                try {
                    fw.append(petStr);
                    fw.flush();
                } catch (IOException e) {
                    System.out.println("Something get wrong.");
                }
            }
            System.out.println();
            fw.close();
        } catch (IOException e) {
            System.out.println("Something get wrong.");
        }
        System.out.println("Success!");
    }


    static void load(ArrayList<Animal> pets) {
        ArrayList<Animal> petsFromBase = new ArrayList<>();

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
                pet.sex = Animal.Sex.valueOf(string[2]);
                pet.name = string[3];
                try {
                    pet.birthday = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy").parse(string[4]);
                } catch (ParseException e) {
                    System.out.println("Invalid date format.");
                }
                pet.description = string[5];
                petsFromBase.add(pet);
                line = reader.readLine();
            }
            fr.close();
            reader.close();
        }  catch (FileNotFoundException e) {
            System.out.println("File not found.");
        } catch (IOException e) {
            System.out.println("Something get wrong.");
        }
        pets.clear();
        pets.addAll(0, petsFromBase);
        System.out.println("Success!");
    }
}
