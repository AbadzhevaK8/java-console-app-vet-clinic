import java.util.*;



class UICycle {

    ArrayList<Animal> pets = new ArrayList<>();

    void addPet(Scanner sc) { //TODO add getters and setters to Animal class for each function

        Animal pet = new Animal();
        Animal.setPetName(pet);
        Animal.setPetKind(sc, pet);
        Animal.setPetSex(sc, pet);
        Animal.setPetName(sc, pet);
        Animal.setPetDate(sc, pet);
        Animal.setPetDescription(sc, pet);

        pets.add(pet);
        System.out.println("Adding successful:");
        System.out.printf("%d. %s %s %s %s %s\n", pet.id, pet.kind, pet.sex, pet.name, pet.birthday, pet.description);
        System.out.println("Pets array size: " + pets.size());
    }

    void list() {
        if (pets.isEmpty()) {
            System.out.println("No pets found.");
        } else {
            System.out.println("List of pets:");
            System.out.printf("%-5s | %-10s | %-6s | %-15s | %-30s | %s\n", "id", "kind", "sex", "name", "birthday", "description");
            System.out.println("-".repeat(100));
            for (Animal pet : pets) {
                System.out.printf("%-5d | %-10s | %-6s | %-15s | %-30s | %s\n", pet.id, pet.kind, pet.sex, pet.name, pet.birthday, pet.description);
            }
        }
    }

    void remove(String removeCommand) {
        String removeStr = removeCommand.replace("REMOVE ", "");
        int removeNumber;
        try {
            removeNumber = Integer.parseInt(removeStr);
            Animal pet = PetDataBase.getPetById(removeNumber, pets);
            pets.remove(pet);
        } catch (NumberFormatException e) {
            System.out.println("Invalid id. Please, repeat the command with the correct pet id.");
        }
    }

    void edit(String editCommand, Scanner sc) { //TODO add getters and setters to Animal class for each function
        String editStr = editCommand.replace("EDIT ", "");
        int editNumber;
        try {
            editNumber = Integer.parseInt(editStr);
            Animal pet = PetDataBase.getPetById(editNumber, pets);
            System.out.print(Manual.EDITMENU);
            int fieldNumber;
            while (true) {
                try {
                    fieldNumber = Integer.parseInt(sc.nextLine());
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Please, enter correct number:");
                }
            }
            if (fieldNumber == 1) {
                Animal.setPetKind(sc, pet);
            } else if (fieldNumber == 2) {
                Animal.setPetSex(sc, pet);
            } else if (fieldNumber == 3) {
                Animal.setPetName(sc, pet);
            } else if (fieldNumber == 4) {
                Animal.setPetDate(sc, pet);
            } else if (fieldNumber == 5) {
                Animal.setPetDescription(sc, pet);
            } else {
                System.out.println("Incorrect field number.");
            }
            System.out.printf("Result: %d. %s %s %s %s %s\n", pet.id, pet.kind, pet.sex, pet.name, pet.birthday, pet.description);
        } catch (NumberFormatException e) {
            System.out.println("Invalid id. Please, repeat the command with the correct pet id.");
        } catch (NullPointerException e) {
            System.out.println("Something get wrong.");
        }
    }


    void doCycle() {
        System.out.println(Manual.LOGO);
        System.out.println(Manual.MANUAL);
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Please, enter the command.");

            String inputCommand = sc.nextLine();
            inputCommand = inputCommand.toUpperCase().trim();

            if (inputCommand.equals("EXIT")) {
                break;
            } else if (inputCommand.equals("ADD")){
                addPet(sc);
            } else if (inputCommand.equals("LIST")) {
                list();
            } else if (inputCommand.startsWith("REMOVE ")) {
                remove(inputCommand);
            } else if (inputCommand.startsWith("EDIT ")) {
                edit(inputCommand, sc);
            } else if (inputCommand.startsWith("SAVE")) {
                PetDataBase.save(pets);
            } else if (inputCommand.startsWith("LOAD")) {
                PetDataBase.load(pets);
            }
        }
    }
}

public class Main {
    public static void main(String[] args) {

        UICycle uiCycle = new UICycle();
        uiCycle.doCycle();

    }
}