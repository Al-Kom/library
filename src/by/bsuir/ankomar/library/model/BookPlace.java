package by.bsuir.ankomar.library.model;

import by.bsuir.ankomar.library.enums.Direction;
import by.bsuir.ankomar.library.enums.Jenre;
import by.bsuir.ankomar.library.enums.Theme;

/*
    Instead of 'createPlace' -- Constructor
    Instead of 'deletePlace' -- Destructor
 */
public class BookPlace {
    private Book book;
    private Theme theme;
    private Direction direction = null;
    private Jenre jenre = null;


    public BookPlace(Book book, Theme theme, Direction direction) {
        this.book = book;
        this.theme = theme;
        this.direction = direction;
    }

    public BookPlace(Book book, Theme theme, Jenre jenre) {
        this.book = book;
        this.theme = theme;
        this.jenre = jenre;
    }
}
