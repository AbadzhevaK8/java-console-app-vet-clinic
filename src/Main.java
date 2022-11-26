import java.util.ArrayList;
//import java.util.Date;
import java.util.Scanner;

// data
//    enum Gender {
//        FEMALE,
//        MALE
//    }

class Animal {
    int id;
    String kind;
    String gender;
    String name;
    String birthday;
    String description;
}

class UICycle {

    ArrayList<Animal> pets = new ArrayList<>();
    void addPet(Scanner sc){
        Animal pet = new Animal();
        pet.id = (!pets.isEmpty()) ? (pets.size() + 1) : 1;
        System.out.println("Enter pet kind:");
        pet.kind = sc.nextLine();
        System.out.println("Enter the gender of the pet (male / female):");
        pet.gender = sc.nextLine();
        System.out.println("Enter pet name:");
        pet.name = sc.nextLine();
        System.out.println("Enter your pet's date of birth (DD/MM/YYYY):");
        pet.birthday = sc.nextLine();
        System.out.println("Enter a description of the pet:");
        pet.description = sc.nextLine();
        pets.add(pet);
        System.out.println("Adding successful:");
        System.out.printf("%d. %s %s %s %s %s", pet.id, pet.kind, pet.gender, pet.name, pet.birthday, pet.description);
        System.out.println(pets.size());
    }

    void doCycle() {
        Scanner sc = new Scanner(System.in);
        boolean itWorks = true;

        while (itWorks) {

            String inputCommand = sc.nextLine();
            inputCommand = inputCommand.toUpperCase();

            if (inputCommand.equals("EXIT")) {
                itWorks = false;
            } else if (inputCommand.equals("ADD")){
                addPet(sc);
            } else if (inputCommand.equals("LIST")) {
                System.out.println("we are inside LIST");
            } else if (inputCommand.startsWith("REMOVE")) {
                System.out.println("we are inside REMOVE");
            } else if (inputCommand.startsWith("EDIT")) {
                System.out.println("we are inside EDIT");
            } else {
                System.out.println("Please, enter the command.");
            }
        }
    }

}
// functions


public class Main {
    public static void main(String[] args) {
// logo and manual
        System.out.println(Manual.LOGO);
        System.out.println(Manual.MANUAL);

        UICycle uiCycle = new UICycle();
        uiCycle.doCycle();

    }
}