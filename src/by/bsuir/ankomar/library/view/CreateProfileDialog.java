package by.bsuir.ankomar.library.view;

import by.bsuir.ankomar.library.controller.VisitorsProfiles;
import by.bsuir.ankomar.library.enums.UserStatus;
import by.bsuir.ankomar.library.model.Visitor;

import javax.swing.*;
import java.awt.*;

public class CreateProfileDialog extends JDialog {

    public CreateProfileDialog(Frame parent) {
        super(parent, "Создать профиль");

        //input panel
        JPanel inputPanel = new JPanel();
        JLabel nameLabel = new JLabel("Имя");
        JLabel surnameLabel = new JLabel("Фамилия");
        JLabel statusLabel = new JLabel("Статус");
        JTextField nameTF = new JTextField();
        JTextField surnameTF = new JTextField();
        String[] userStatus = {"ПОСЕТИТЕЛЬ","ВЛАДЕЛЕЦ"};
        JComboBox<String> statusCB = new JComboBox<String>(userStatus);
        inputPanel.setLayout( new GridLayout(3,2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameTF);
        inputPanel.add(surnameLabel);
        inputPanel.add(surnameTF);
        inputPanel.add(statusLabel);
        inputPanel.add(statusCB);

        //button
        JButton createButton = new JButton("Создать");
        createButton.addActionListener(e -> {
            //add user to model
            UserStatus status = (statusCB.getSelectedItem() == "ВЛАДЕЛЕЦ")
                    ? UserStatus.OWNER
                    : UserStatus.VISITOR;
            Visitor visitor = new Visitor(nameTF.getText(), surnameTF.getText(), status);
            VisitorsProfiles.INSTANCE.add(visitor);
            //close dialog
            dispose();
            //enter to user profile
            if(status == UserStatus.VISITOR) {
                new VisitorGui(visitor);
            }
            else {
                new OwnerGui(visitor);
            }
        });

        setLayout( new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(inputPanel);
        getContentPane().add(createButton);
        pack();
        setVisible(true);
    }


}
