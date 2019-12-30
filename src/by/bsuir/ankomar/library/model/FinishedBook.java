package by.bsuir.ankomar.library.model;

/*
    Instead of 'createFinishedBook' -- Constructor
    Instead of 'deleteFinishedBook' -- Destructor
 */
public class FinishedBook {
    public final Book book;
    private int rating;

    public FinishedBook(Book book, int rating) {
        this.book = book;
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

}
