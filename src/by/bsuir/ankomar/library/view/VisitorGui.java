package by.bsuir.ankomar.library.view;

import by.bsuir.ankomar.library.model.Visitor;

import javax.swing.*;
import java.awt.*;

/*
    'UI' in class diagram
 */
public class VisitorGui extends JFrame {

    public VisitorGui(Visitor visitor) {
        super("Домашняя библиотека");

        //user buttons
        JButton takeBook = new JButton("Взять книгу");
        JButton returnBook = new JButton("Вернуть книгу");
//        JButton editProfile = new JButton("Редактировать профиль");

        getContentPane().setLayout(new GridLayout(1,2));
        getContentPane().add(takeBook);
        getContentPane().add(returnBook);
        pack();

        setVisible(true);
    }

}
