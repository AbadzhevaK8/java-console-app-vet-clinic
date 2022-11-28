import org.jetbrains.annotations.NotNull;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

class Animal {
    int id;
    String kind;
    String gender;
    String name;
    Date birthday;
    String description;
}

class UICycle {

    ArrayList<Animal> pets = new ArrayList<>();
    int petsIdCounter = 0;

    void addPet(@NotNull Scanner sc) throws ParseException { // FIXME Зачем IDE настояла добавить тут @NotNull?
        petsIdCounter++;
        Animal pet = new Animal();
        pet.id = petsIdCounter;
        System.out.println("Enter pet kind:");
        pet.kind = sc.nextLine();
        System.out.println("Enter the gender of the pet (male / female):");
        pet.gender = sc.nextLine();
        System.out.println("Enter pet name:");
        pet.name = sc.nextLine();
        System.out.println("Enter your pet's date of birth (DD/MM/YYYY):");
        pet.birthday = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine()); // TODO add try catch for date.
        System.out.println("Enter a description of the pet:");
        pet.description = sc.nextLine();
        pets.add(pet);
        System.out.println("Adding successful:");
        System.out.printf("%d. %s %s %s %s %s\n", pet.id, pet.kind, pet.gender, pet.name, pet.birthday, pet.description);
        System.out.println("Pets array size: " + pets.size());

    }

    void list() {
        if (pets.isEmpty()) {
            System.out.println("No pets found.");
        } else {
            System.out.println("List of pets:");
            System.out.printf("%-5s | %-10s | %-6s | %-15s | %-30s | %s\n", "id", "kind", "gender", "name", "birthday", "description");
            System.out.println("-".repeat(100));
            for (Animal pet : pets) {
                System.out.printf("%-5d | %-10s | %-6s | %-15s | %-30s | %s\n", pet.id, pet.kind, pet.gender, pet.name, pet.birthday, pet.description);
            }
        }
    }

    void remove(String removeCommand) {
        int removeNumber = Integer.parseInt(removeCommand.replace("REMOVE ", "")); // TODO add try catch for number.
        for (Animal p : pets) {
            if (p.id == removeNumber) {
                pets.removeIf(pet -> pet.id == removeNumber);
            } else {
                System.out.println("Id not found. Please, repeat the command with the correct pet id:");
            }
        }
    }

    void edit(String editCommand, Scanner sc) throws ParseException { // FIXME пока не знаю что делать с throws ParseException но это про Date.
        int editNumber = Integer.parseInt(editCommand.replace("EDIT ", "")); // TODO add try catch for number.
        System.out.println(Manual.EDITMENU);
        int fieldNumber = Integer.parseInt(sc.nextLine());
        for (Animal p : pets) {
            if (p.id == editNumber) {
                if (fieldNumber == 1) {
                    System.out.println("Enter new kind:");
                    p.kind = sc.nextLine();
                } else if (fieldNumber == 2) {
                        p.gender = sc.nextLine();
                } else if (fieldNumber == 3) {
                        System.out.println("Enter new name:");
                        p.name = sc.nextLine();
                } else if (fieldNumber == 4) {
                        System.out.println("Enter new pet's date of birth (DD/MM/YYYY):");
                        p.birthday = new SimpleDateFormat("dd/MM/yyyy").parse(sc.nextLine());
                } else if (fieldNumber == 5) {
                        System.out.println("Enter new description:");
                        p.description = sc.nextLine();
                } else {
                     System.out.println("Please, enter correct field number:");
                }
            } else {
                System.out.println("Id not found. Please, repeat the command with the correct pet id:");
            }
        }
    }

    void doCycle() throws ParseException { // FIXME пока не знаю что делать с throws ParseException.
        System.out.println(Manual.LOGO);
        System.out.println(Manual.MANUAL);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please, enter the command.");

            String inputCommand = sc.nextLine();
            inputCommand = inputCommand.toUpperCase();

            if (inputCommand.equals("EXIT")) {
                break;
            } else if (inputCommand.equals("ADD")){
                addPet(sc);
            } else if (inputCommand.equals("LIST")) {
                list();
            } else if (inputCommand.startsWith("REMOVE")) {
                remove(inputCommand);
            } else if (inputCommand.startsWith("EDIT")) {
                edit(inputCommand, sc);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) throws ParseException { // FIXME пока не знаю что делать с throws ParseException.

        UICycle uiCycle = new UICycle();
        uiCycle.doCycle();

    }
}