import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        enum Gender {
            FEMALE,
            MALE
        }

        class Animal {
            int id;
            String kind;
            Gender gender;
            String name;
            Date birthday;
            String description;
        }

        ArrayList<Animal> pets = new ArrayList<>();

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
                                                                                          \s
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

        String inputCommand;
        Scanner sc = new Scanner(System.in);
        inputCommand = sc.nextLine();

        while (!inputCommand.equalsIgnoreCase("EXIT")) {
            System.out.println("we are inside while");
            inputCommand = sc.nextLine();

        }

    }
}