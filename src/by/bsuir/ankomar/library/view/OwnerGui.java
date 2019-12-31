package by.bsuir.ankomar.library.view;

import by.bsuir.ankomar.library.connector.UsersConnector;
import by.bsuir.ankomar.library.model.Visitor;

import javax.swing.*;
import java.awt.*;

/*
    'Extended UI' in class diagram
 */
public class OwnerGui extends VisitorGui {

    public OwnerGui(Visitor visitor) {
        super(visitor);

        //add owner gui to connector
        UsersConnector.INSTANCE.setOwnerGui(this);

        //additional buttons
        JButton addBook = new JButton("Добавить книгу");
        JButton deleteBook = new JButton("Удалить книгу");


        getContentPane().setLayout(new GridLayout(2,2));
        getContentPane().add(addBook);
        getContentPane().add(deleteBook);
        pack();

        //button listeners
        addBook.addActionListener(e -> new AddBookDialog(OwnerGui.this));

        update(getGraphics());
    }
}
