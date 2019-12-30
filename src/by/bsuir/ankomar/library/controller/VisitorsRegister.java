package by.bsuir.ankomar.library.controller;

import by.bsuir.ankomar.library.model.VisitorsRegisterEntry;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VisitorsRegister implements DataStorage {
    List<VisitorsRegisterEntry> entries;

    public VisitorsRegister() {
        entries = new ArrayList<>();
    }

    @Override
    public void add(Object entry) {
        entries.add((VisitorsRegisterEntry) entry);
    }

    @Override
    public void delete(Object entry) {
        entries.remove(entry);
    }

    public void editEntry(VisitorsRegisterEntry entry) {
        Date date = new Date(); //current date
        entry.updateEntry(entry.book, entry.surname, date);
    }
}
