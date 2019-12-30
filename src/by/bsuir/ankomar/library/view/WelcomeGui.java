package by.bsuir.ankomar.library.view;

import by.bsuir.ankomar.library.controller.VisitorsProfiles;

import javax.swing.*;
import java.awt.*;

public class WelcomeGui extends JFrame {

    private VisitorsProfiles visitorsProfiles;

    public WelcomeGui() {
        super("Вход");
        setBounds(300, 300, 200, 70);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        int centerX = (getWidth() - getX()) / 2;
//        int centerY = (getHeight() - getX()) / 2;
    }

    public void launchGui(VisitorsProfiles visitorsProfiles) {
        this.visitorsProfiles = visitorsProfiles;

        //create welcome gui components
        JPanel welcomePanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Добро пожаловать!");
        JButton visitLibraryButton = new JButton("Посетить библиотеку");
        visitLibraryButton.addActionListener(e -> {
            new CreateProfileDialog(this, visitorsProfiles);
        });

        welcomePanel.setLayout( new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(visitLibraryButton);
        getContentPane().add(welcomePanel);

        //run gui
        setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setVisible(true);
    }
}
