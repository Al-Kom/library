package by.bsuir.ankomar.library.controller;

import by.bsuir.ankomar.library.model.Visitor;
import by.bsuir.ankomar.library.view.EditVisitorGui;

import java.util.ArrayList;
import java.util.List;

public class VisitorsProfiles implements DataStorage {
    public static final VisitorsProfiles INSTANCE = new VisitorsProfiles();
    private List<Visitor> visitors;

    private VisitorsProfiles() { visitors = new ArrayList<>(); }

    public void add(Object visitor) { visitors.add((Visitor) visitor); }

    public void delete(Object visitor) {
        visitors.remove(visitor);
    }

    public void changeVisitor(Visitor visitor) {
        for (Visitor vi : visitors) {
            if (vi == visitor) {
                //create change gui
                new EditVisitorGui(null, vi);
            }
        }
    }
}
