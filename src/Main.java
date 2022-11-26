import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    // data
    enum Gender {
        FEMALE,
        MALE
    }

    static class Animal {
        int id;
        String kind;
        Gender gender;
        String name;
        Date birthday;
        String description;
    }

    static ArrayList<Animal> pets = new ArrayList<>();

    // functions
    static void addPet(Scanner sc){
        Animal pet = new Animal();
        pet.id = (!pets.isEmpty()) ? (pets.size() + 1) : 0;
        System.out.println("Enter pet kind:");
        pet.kind = sc.nextLine();
        System.out.println("Enter the gender of the pet:");
        System.out.println("Enter pet name:");
        pet.name = sc.nextLine();
        System.out.println("Enter your pet's date of birth:");
        System.out.println("Enter a description of the pet:");
        pet.description = sc.nextLine();
    }

    public static void main(String[] args) {
// logo and manual
        final String LOGO = """
                                                                                          \s
                                                       ,,    ,,                ,,         \s
                `7MMF'   `7MF'       mm              `7MM    db                db         \s
                  `MA     ,V         MM                MM                                 \s
                   VM:   ,V .gP"Ya mmMMmm      ,p6"bo  MM  `7MM  `7MMpMMMb.  `7MM  ,p6"bo \s
                    MM.  M',M'   Yb  MM       6M'  OO  MM    MM    MM    MM    MM 6M'  OO \s
                    `MM A' 8M""\"""\"  MM       8M       MM    MM    MM    MM    MM 8M      \s
                     :MM;  YM.    ,  MM       YM.    , MM    MM    MM    MM    MM YM.    ,\s
                      VF    `Mbmmd'  `Mbmo     YMbmd'.JMML..JMML..JMML  JMML..JMML.YMbmd' \s
                """;
        final String MANUAL = """
                +--------------------------------------------------------+
                |                        COMMANDS                        |
                +--------------------------------------------------------+
                | ADD - add a pet.                                       |
                | LIST - data on all available pets.                     |
                | REMOVE n - remove pet number n from the list.          |
                | EDIT n - edit pet information.                         |
                | EXIT - exit from the program.                          |
                +--------------------------------------------------------+""".indent(7);

        System.out.println(LOGO);
        System.out.println(MANUAL);


// interactions

        // main loop
        Scanner sc = new Scanner(System.in);
        boolean itWorks = true;

        while (itWorks) {

            String inputCommand = sc.nextLine();
            inputCommand = inputCommand.toUpperCase();

            if (inputCommand.equals("EXIT")) {
                itWorks = false;
            } else if (inputCommand.equals("ADD")){
                System.out.println("we are inside ADD");
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