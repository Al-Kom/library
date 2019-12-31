package by.bsuir.ankomar.library.controller;

import by.bsuir.ankomar.library.model.BookPlace;

import java.util.ArrayList;
import java.util.List;

public class BookStorage implements DataStorage {
    public static final BookStorage INSTANCE = new BookStorage();
    private List<BookPlace> storage;

    private BookStorage() {
        storage = new ArrayList<>();
    }

    @Override
    public void add(Object place) {
        storage.add((BookPlace) place);
    }

    @Override
    public void delete(Object place) {
        storage.remove(place);
    }

    public BookPlace getBookPlace(String bookName) {
        for (BookPlace place : storage) {
            if(place.getBook().name.equals(bookName))
                return place;
        }
        return null;
    }
}
