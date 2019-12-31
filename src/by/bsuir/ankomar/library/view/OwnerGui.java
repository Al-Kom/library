package by.bsuir.ankomar.library.view;

import by.bsuir.ankomar.library.connector.UsersConnector;
import by.bsuir.ankomar.library.controller.BookStorage;
import by.bsuir.ankomar.library.controller.VisitorsRegister;
import by.bsuir.ankomar.library.model.BookPlace;
import by.bsuir.ankomar.library.model.Visitor;
import by.bsuir.ankomar.library.model.VisitorsRegisterEntry;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

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

    public void showTakeBook(Visitor visitor, BookPlace bookPlace) {
        String message = "Посетитель " + visitor.name + " " + visitor.surname
                + " хочет взять книгу \"" + bookPlace.getBook().name + "\". Добавить запись о взятии в учет книг?";
        JOptionPane.showMessageDialog(this, message);
        //add entry to visitor's register
        Date currentDate = new Date();
        VisitorsRegister.INSTANCE.add(
                new VisitorsRegisterEntry(bookPlace.getBook(), visitor.surname, currentDate));
        //remove book from storage
        BookStorage.INSTANCE.delete(bookPlace);
        //send message to visitor
        String outputMessage = "Книга " + bookPlace.getBook().name + " успешно взята";
        VisitorGui visitorGui = UsersConnector.INSTANCE.getVisitorGui(visitor);
        if(visitorGui != null)
            visitorGui.showMessage(outputMessage);
    }
}
