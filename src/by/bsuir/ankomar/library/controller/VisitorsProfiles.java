package by.bsuir.ankomar.library.controller;

import by.bsuir.ankomar.library.model.Visitor;

import java.util.ArrayList;
import java.util.List;

public class VisitorsProfiles implements DataStorage {
    private List<Visitor> visitors;

    public VisitorsProfiles() { visitors = new ArrayList<>(); }

    public void add(Object visitor) { visitors.add((Visitor) visitor); }

    public void delete(Object visitor) {
        visitors.remove(visitor);
    }

    public void changeVisitor(Visitor visitor) {
        //TODO: dialog to change
    }

}
