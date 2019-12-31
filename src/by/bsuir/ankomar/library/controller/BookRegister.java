package by.bsuir.ankomar.library.controller;

import by.bsuir.ankomar.library.model.BookRegisterEntry;

import java.util.ArrayList;
import java.util.List;

public class BookRegister implements DataStorage{
    public static final BookRegister INSTANSE = new BookRegister();
    private List<BookRegisterEntry> entries;

    private BookRegister() {
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

    public BookRegisterEntry getEntry(String bookName) {
        for (BookRegisterEntry entry : entries) {
            if(bookName.equals(entry.book.name))
                return entry;
        }
        return null;
    }
}
