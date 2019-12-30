package by.bsuir.ankomar.library.model;

import java.util.Date;

/*
    Instead of 'createEntry' -- Constructor
    Instead of 'deleteEntry' -- Destructor
 */
public class VisitorsRegisterEntry {
    public final Book book;
    private Date takeDate;
    private Date returnDate;
    public final String surname;

    public VisitorsRegisterEntry(Book book, String surname, Date takeDate) {
        this.book = book;
        this.surname = surname;
        this.takeDate = takeDate;
    }

    public void updateEntry(Book book, String surname, Date returnDate) {
        if(this.book == book && this.surname == surname) {
            this.returnDate = returnDate;
        }
    }
}
