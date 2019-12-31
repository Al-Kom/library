package by.bsuir.ankomar.library.model;

import by.bsuir.ankomar.library.enums.BookStatus;

public class BookRegisterEntry {
    public final Book book;
    private int averageRating;
    private BookStatus status;
    private int ratingCounter;

    public BookRegisterEntry(Book book, int averageRating, BookStatus status) {
        this.book = book;
        this.averageRating = averageRating;
        this.status = status;
        ratingCounter = 0;
    }

    public void editEntry(FinishedBook finishedBook) {
        if (finishedBook.book == book) {
            recalculateAverageRating(finishedBook.getRating());
        }
    }

    private void recalculateAverageRating(int additionalRating) {
        averageRating = (averageRating*ratingCounter + additionalRating) / (++ratingCounter);
    }

    public BookStatus getStatus() {
        return status;
    }

    public void setStatus(BookStatus status) { this.status = status; }
}
