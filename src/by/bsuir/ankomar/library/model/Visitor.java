package by.bsuir.ankomar.library.model;

import by.bsuir.ankomar.library.enums.UserStatus;

import java.util.ArrayList;
import java.util.List;

/*
    Instead of 'createVisitorProfile' -- Constructor
    Instead of 'deleteVisitorProfile' -- Destructor
 */
public class Visitor {

    public final String name;
    public final String surname;
    private UserStatus status;
    private List<FinishedBook> finishedBooks;
    private List<Book> favouriteBooks;
    private List<Book> plannedBooks;

    public Visitor(String name, String surname, UserStatus status) {
        this.name = name;
        this.surname = surname;
        this.status = status;
        finishedBooks = new ArrayList<>();
        favouriteBooks = new ArrayList<>();
        plannedBooks = new ArrayList<>();
    }

    public void addToList(List<Book> bookList, Book book) {
        if (bookList == favouriteBooks) {
            favouriteBooks.add(book);
        } else if (bookList == plannedBooks) {
            plannedBooks.add(book);
        }
    }

    public void addToList(List<FinishedBook> bookList, FinishedBook finishedBook) {
        if (bookList == finishedBooks) {
            finishedBooks.add(finishedBook);
        }
    }

    public void deleteFromList(List<Book> bookList, Book book) {
        if (bookList == favouriteBooks) {
            favouriteBooks.remove(book);
        } else if (bookList == plannedBooks) {
            plannedBooks.remove(book);
        }
    }

    public void removeFromList(List<FinishedBook> bookList, FinishedBook finishedBook) {
        if (bookList == finishedBooks) {
            finishedBooks.add(finishedBook);
        }
    }
}
