package by.bsuir.ankomar.library.model;

/*
    Instead of 'createBook' -- Constructor
    Instead of 'deleteBook' -- Destructor
 */
public class Book {

    public final String name;
    private String author;
    private int year;
    private String publishingHouse;

    public Book(String name, String author, int year, String publishingHouse) {
        this.name = name;
        this.author = author;
        this.year = year;
        this.publishingHouse = publishingHouse;
    }
}
