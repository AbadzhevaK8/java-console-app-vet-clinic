import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

enum Sex {
    FEMALE,
    MALE,
    OTHER
        }

class Animal {
    int id;
    String kind;
    String sex;
    String name;
    Date birthday;
    String description;
}

class UICycle {

    ArrayList<Animal> pets = new ArrayList<>();
    int petsIdCounter = 0;

    void addPet(Scanner sc) {
        petsIdCounter++;
        Animal pet = new Animal();
        pet.id = petsIdCounter;

        System.out.println("Enter pet kind:");
        pet.kind = sc.nextLine();

        System.out.println(Manual.SEXMENU);
        String strSex = sc.nextLine();
        if (Objects.equals(strSex, "1")) {
            pet.sex = String.valueOf(Sex.FEMALE);
        } else if (Objects.equals(strSex, "2")) {
            pet.sex = String.valueOf(Sex.MALE);
        } else {
            pet.sex = String.valueOf(Sex.OTHER);
        }

        System.out.println("Enter pet name:");
        pet.name = sc.nextLine();

        System.out.println("Enter your pet's date of birth (DD/MM/YYYY):");
        while (true) {
            String dateStr = sc.nextLine();
            try {
                pet.birthday = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
                break;
            } catch (ParseException e) {
                System.out.println("Invalid date format. Please, enter your pet's date of birth (DD/MM/YYYY): ");
            }
        }

        System.out.println("Enter a description of the pet:");
        pet.description = sc.nextLine();

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
            for (Animal p : pets) {
                if (p.id == removeNumber) {
                    pets.removeIf(pet -> pet.id == removeNumber);
                } else {
                    System.out.println("Id not found. Please, repeat the command with the correct pet id.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid id. Please, repeat the command with the correct pet id.");
        }
    }

    void edit(String editCommand, Scanner sc) {
        String editStr = editCommand.replace("EDIT ", "");
        int editNumber;
        try {
            editNumber = Integer.parseInt(editStr);
            for (Animal p : pets) {
                if (p.id == editNumber) {
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
                        System.out.println("Enter new kind:");
                        p.kind = sc.nextLine();
                        System.out.printf("%d. %s %s %s %s %s\n", p.id, p.kind, p.sex, p.name, p.birthday, p.description);
                    } else if (fieldNumber == 2) {
                        System.out.println(Manual.SEXMENU);
                        String strSex = sc.nextLine();
                        if (Objects.equals(strSex, "1")) {
                            p.sex = String.valueOf(Sex.FEMALE);
                        } else if (Objects.equals(strSex, "2")) {
                            p.sex = String.valueOf(Sex.MALE);
                        } else {
                            p.sex = String.valueOf(Sex.OTHER);
                        }
                        System.out.printf("%d. %s %s %s %s %s\n", p.id, p.kind, p.sex, p.name, p.birthday, p.description);
                    } else if (fieldNumber == 3) {
                        System.out.println("Enter new name:");
                        p.name = sc.nextLine();
                        System.out.printf("%d. %s %s %s %s %s\n", p.id, p.kind, p.sex, p.name, p.birthday, p.description);
                    } else if (fieldNumber == 4) {
                        System.out.println("Enter new pet's date of birth (DD/MM/YYYY):");
                        while (true) {
                            String dateStr = sc.nextLine();
                            try {
                                p.birthday = new SimpleDateFormat("dd/MM/yyyy").parse(dateStr);
                                break;
                            } catch (ParseException e) {
                                System.out.println("Invalid date format. Please, enter new pet's date of birth (DD/MM/YYYY): ");
                            }
                        }
                        System.out.printf("%d. %s %s %s %s %s\n", p.id, p.kind, p.sex, p.name, p.birthday, p.description);
                    } else if (fieldNumber == 5) {
                        System.out.println("Enter new description:");
                        p.description = sc.nextLine();
                        System.out.printf("%d. %s %s %s %s %s\n", p.id, p.kind, p.sex, p.name, p.birthday, p.description);
                    } else {
                        System.out.println("Incorrect field number.");
                    }
                } else {
                    System.out.println("Id not found. Please, repeat the command with the correct pet id.");
                }
            }
        } catch (NumberFormatException e) {
            System.out.println("Invalid id. Please, repeat the command with the correct pet id.");
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