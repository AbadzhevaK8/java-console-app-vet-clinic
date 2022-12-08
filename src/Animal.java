import java.util.Date;

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
}
