package by.bsuir.ankomar.library.connector;

import by.bsuir.ankomar.library.model.Visitor;
import by.bsuir.ankomar.library.view.OwnerGui;
import by.bsuir.ankomar.library.view.VisitorGui;

import java.util.ArrayList;
import java.util.List;

public class UsersConnector {
    public static final UsersConnector INSTANCE = new UsersConnector();
    private OwnerGui ownerGui = null;
    private List<VisitorGui> visitorGuis;

    private UsersConnector() { visitorGuis = new ArrayList<>(); }

    public void setOwnerGui(OwnerGui ownerGui) {
        this.ownerGui = ownerGui;
        addVisitorGui(ownerGui);
    }

    public void addVisitorGui(VisitorGui visitorGui) { visitorGuis.add(visitorGui); }

    public OwnerGui getOwnerGui() {
        return ownerGui;
    }

    public VisitorGui getVisitorGui(Visitor visitor) {
        for (VisitorGui vg : visitorGuis) {
            if(vg.getVisitor().equals(visitor))
                return vg;
        }
        return null;
    }
}
