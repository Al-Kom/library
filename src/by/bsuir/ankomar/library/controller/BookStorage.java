package by.bsuir.ankomar.library.controller;

import by.bsuir.ankomar.library.model.BookPlace;

import java.util.ArrayList;
import java.util.List;

public class BookStorage implements DataStorage {
    private List<BookPlace> storage;

    public BookStorage() {
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
}
