package by.bsuir.ankomar.library.view;

import by.bsuir.ankomar.library.connector.UsersConnector;
import by.bsuir.ankomar.library.model.Visitor;

import javax.swing.*;
import java.awt.*;

/*
    'UI' in class diagram
 */
public class VisitorGui extends JFrame {

    private Visitor visitor;

    public VisitorGui(Visitor visitor) {
        super("Домашняя библиотека");

        this.visitor = visitor;

        //add visitor gui to connector
        UsersConnector.INSTANCE.addVisitorGui(this);

        //user buttons
        JButton takeBook = new JButton("Взять книгу");
        JButton returnBook = new JButton("Вернуть книгу");

        getContentPane().setLayout(new GridLayout(1,2));
        getContentPane().add(takeBook);
        getContentPane().add(returnBook);

        pack();

        //TODO:listeners
        takeBook.addActionListener(e -> new TakeBookDialog(this, visitor));

        setVisible(true);
    }

    public Visitor getVisitor() {
        return visitor;
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message,"",JOptionPane.PLAIN_MESSAGE);
    }

}
