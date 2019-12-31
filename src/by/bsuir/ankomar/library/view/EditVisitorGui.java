package by.bsuir.ankomar.library.view;

import by.bsuir.ankomar.library.enums.UserStatus;
import by.bsuir.ankomar.library.model.Visitor;

import javax.swing.*;
import java.awt.*;

public class EditVisitorGui extends JDialog {

    public EditVisitorGui(JFrame frame, Visitor visitor) {
        super(frame,"Редактирование профиля");

        //profile panel
        JLabel nameLabel = new JLabel("Имя");
        JLabel profileNameLabel = new JLabel(visitor.name);
        JLabel surnameLabel = new JLabel("Фамилия");
        JLabel profileSurnameLabel = new JLabel(visitor.surname);
        JLabel statusLabel = new JLabel("Статус");
        String stringStatus = (visitor.getStatus() == UserStatus.VISITOR)
                ? "ПОСЕТИТЕЛЬ"
                : "ВЛАДЕЛЕЦ";
        JLabel profileStatusLabel = new JLabel(stringStatus);
        JPanel profilePanel = new JPanel();
        profilePanel.setLayout( new GridLayout(3,2));
        profilePanel.add(nameLabel);
        profilePanel.add(profileNameLabel);
        profilePanel.add(surnameLabel);
        profilePanel.add(profileSurnameLabel);
        profilePanel.add(statusLabel);
        profilePanel.add(profileStatusLabel);

        //buttons panel
        JLabel addLabel = new JLabel("Добавить к");
        JLabel removeLabel = new JLabel("Удалить из");
        JButton addToPlanned = new JButton("- запланированным");
        JButton addToFavourite = new JButton("- любимым");
        JButton addToFinished = new JButton("- прочитанным");
        JButton removeFromPlanned = new JButton("- запланированных");
        JButton removeFromFavourite = new JButton("- любимых");
        JButton removeFromFinished = new JButton("- прочитанных");
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4,2));
        panel.add(addLabel);
        panel.add(removeLabel);
        panel.add(addToPlanned);
        panel.add(removeFromPlanned);
        panel.add(addToFavourite);
        panel.add(removeFromFavourite);
        panel.add(addToFinished);
        panel.add(removeFromFinished);

        //TODO:button listeners

        //run dialog

        setLayout( new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(profilePanel);
        getContentPane().add(panel);
        pack();
        setVisible(true);
    }
}
