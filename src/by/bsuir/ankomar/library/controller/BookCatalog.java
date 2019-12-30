package by.bsuir.ankomar.library.controller;

import by.bsuir.ankomar.library.model.BookRegisterEntry;

import java.util.ArrayList;
import java.util.List;

public class BookCatalog implements DataStorage{
    private List<BookRegisterEntry> entries;

    public BookCatalog() {
        entries = new ArrayList<>();
    }

    @Override
    public void add(Object entry) {
        entries.add((BookRegisterEntry) entry);
    }

    @Override
    public void delete(Object entry) {
        entries.remove(entry);
    }
}
