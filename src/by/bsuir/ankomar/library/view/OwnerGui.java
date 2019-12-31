package by.bsuir.ankomar.library.view;

import by.bsuir.ankomar.library.connector.UsersConnector;
import by.bsuir.ankomar.library.controller.BookRegister;
import by.bsuir.ankomar.library.controller.VisitorsRegister;
import by.bsuir.ankomar.library.enums.BookStatus;
import by.bsuir.ankomar.library.model.BookRegisterEntry;
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
        deleteBook.addActionListener(e -> new DeleteBookDialog(this));

        update(getGraphics());
    }

    public void showTakeBook(Visitor visitor, BookRegisterEntry entry) {
        String message = "Посетитель " + visitor.name + " " + visitor.surname
                + " хочет взять книгу \"" + entry.book.name + "\". Добавить запись о взятии в учет книг?";
        JOptionPane.showMessageDialog(this, message);
        //add entry to visitor's register
        Date currentDate = new Date();
        VisitorsRegister.INSTANCE.add(
                new VisitorsRegisterEntry(entry.book, visitor.surname, currentDate));
        //set book entry status
        entry.setStatus(BookStatus.BORROWED);
        //send message to visitor
        String outputMessage = "Книга " + entry.book.name + " успешно взята";
        VisitorGui visitorGui = UsersConnector.INSTANCE.getVisitorGui(visitor);
        if(visitorGui != null)
            visitorGui.showMessage(outputMessage);
    }

    public void showReturnBook(Visitor visitor, VisitorsRegisterEntry entry) {
        String message = "Посетитель " + visitor.name + " " + visitor.surname
                + " хочет вернуть книгу \"" + entry.book.name + "\". Изменить запись в учете книг?";
        JOptionPane.showMessageDialog(this, message);
        //edit entry in visitor's register
        VisitorsRegister.INSTANCE.editEntry(entry);
        //set book entry status
        BookRegister.INSTANSE.getEntry(entry.book.name).setStatus(BookStatus.AVAILABLE);
        //send message to visitor
        String outputMessage = "Книга " + entry.book.name + " успешно возвращена";
        VisitorGui visitorGui = UsersConnector.INSTANCE.getVisitorGui(visitor);
        if(visitorGui != null)
            visitorGui.showMessage(outputMessage);
    }
}
