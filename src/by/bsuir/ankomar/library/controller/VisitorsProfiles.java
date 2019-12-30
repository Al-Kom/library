package by.bsuir.ankomar.library.controller;

import by.bsuir.ankomar.library.model.Visitor;

import java.util.ArrayList;
import java.util.List;

public class VisitorsProfiles {
    private List<Visitor> visitors;

    public VisitorsProfiles() { visitors = new ArrayList<>(); }

    public void addVisitor(Visitor visitor) { visitors.add(visitor); }

    public void removeVisitor(Visitor visitor) {
        visitors.remove(visitor);
    }

    public void changeVisitor(Visitor visitor) {
//        visitor.changeSmth;
    }

}
