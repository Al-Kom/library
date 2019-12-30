package by.bsuir.ankomar.library.launcher;
import by.bsuir.ankomar.library.controller.VisitorsProfiles;
import by.bsuir.ankomar.library.view.WelcomeGui;

public class Library {
    public static void main(String[] args) {
        WelcomeGui gui = new WelcomeGui();
        VisitorsProfiles visitorsProfiles = new VisitorsProfiles();


        gui.launchGui(visitorsProfiles);
    }
}
