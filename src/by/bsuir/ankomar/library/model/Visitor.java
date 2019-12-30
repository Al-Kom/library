package by.bsuir.ankomar.library.model;

public class Visitor {

    public final String name;
    public final String surname;
    private UserStatus status;

    public Visitor(String name, String surname, UserStatus status) {
        this.name = name;
        this.surname = surname;
        this.status = status;
    }

    //other
}
