public class Manual {
     static final String LOGO = """
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

     static final String MANUAL = """
                +--------------------------------------------------------+
                |                        COMMANDS                        |
                +--------------------------------------------------------+
                | ADD - add a pet.                                       |
                | LIST - data on all available pets.                     |
                | REMOVE n - remove pet number n from the list.          |
                | EDIT n - edit pet information. n is pt id number.      |
                | EXIT - exit from the program.                          |
                +--------------------------------------------------------+""".indent(7);

     static final String EDITMENU = """
            +-----------------------+
            | Select field to edit: |
            +-----------------------+
            | 1 - kind              |
            | 2 - sex               |
            | 3 - name              |
            | 4 - birth date        |
            | 5 - description       |
            +-----------------------+
            """;

     static final String SEXMENU = """
+--------------------------------+
| Specify the gender of the pet: |
+--------------------------------+
| 1 - female                     |
| 2 - male                       |
| 3 - other                      |
+--------------------------------+
             """;
}

