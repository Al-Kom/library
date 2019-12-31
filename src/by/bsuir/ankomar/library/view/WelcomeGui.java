package by.bsuir.ankomar.library.view;

import javax.swing.*;
import java.awt.*;

public class WelcomeGui extends JFrame {


    public WelcomeGui() {
        super("Вход");
    }

    public void launchGui() {

        //create welcome gui components
        JPanel welcomePanel = new JPanel();
        JLabel welcomeLabel = new JLabel("Добро пожаловать!");
        JButton visitLibraryButton = new JButton("Посетить библиотеку");
        visitLibraryButton.addActionListener(e -> new CreateProfileDialog(this));

        welcomePanel.setLayout( new BoxLayout(welcomePanel, BoxLayout.Y_AXIS));
        welcomePanel.add(welcomeLabel);
        welcomePanel.add(visitLibraryButton);
        getContentPane().add(welcomePanel);

        //run gui
        setBounds(300, 300, 200, 70);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setModalExclusionType(Dialog.ModalExclusionType.APPLICATION_EXCLUDE);
        setVisible(true);
    }
}
