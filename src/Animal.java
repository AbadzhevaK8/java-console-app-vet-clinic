import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;
import java.util.Scanner;

class Animal {

    int id;
    String kind;
    Sex sex;
    String name;
    Date birthday;
    String description;

    enum Sex {
        FEMALE,
        MALE,
        OTHER
    }

    static void setPetName(Animal pet) {
        int petsIdCounter = PetDataBase.petIdChecker();
        petsIdCounter++;
        pet.id = petsIdCounter;
    }

    static void setPetKind(Scanner sc, Animal pet) {
        System.out.println("Enter pet kind:");
        pet.kind = sc.nextLine();
    }

    static void setPetSex(Scanner sc, Animal pet) {
        System.out.println(Manual.SEXMENU);
        String strSex = sc.nextLine();
        if (Objects.equals(strSex, "1")) {
            pet.sex = Animal.Sex.FEMALE;
        } else if (Objects.equals(strSex, "2")) {
            pet.sex = Animal.Sex.MALE;
        } else {
            pet.sex = Animal.Sex.OTHER;
        }
    }

    static void setPetName(Scanner sc, Animal pet) {
        System.out.println("Enter pet name:");
        pet.name = sc.nextLine();
    }

    static void setPetDate(Scanner sc, Animal pet) {
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
    }

    static void setPetDescription(Scanner sc, Animal pet) {
        System.out.println("Enter a description of the pet:");
        pet.description = sc.nextLine();
    }

}
