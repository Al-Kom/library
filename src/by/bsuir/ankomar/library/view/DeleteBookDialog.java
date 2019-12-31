package by.bsuir.ankomar.library.view;

import by.bsuir.ankomar.library.controller.BookRegister;
import by.bsuir.ankomar.library.controller.BookStorage;
import by.bsuir.ankomar.library.controller.VisitorsProfiles;
import by.bsuir.ankomar.library.controller.VisitorsRegister;
import by.bsuir.ankomar.library.model.BookPlace;
import by.bsuir.ankomar.library.model.BookRegisterEntry;
import by.bsuir.ankomar.library.model.Visitor;
import by.bsuir.ankomar.library.model.VisitorsRegisterEntry;

import javax.swing.*;
import java.awt.*;

public class DeleteBookDialog extends JDialog {

    public DeleteBookDialog(JFrame parent) {
        super(parent,"Удаление книги");


        //input panel
        JPanel inputPanel = new JPanel();
        JLabel nameLabel = new JLabel("Название книги");
        JTextField nameTF = new JTextField();
        inputPanel.setLayout( new GridLayout(1, 2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameTF);

        //button panel
        JButton deleteButton = new JButton("Удалить");
        deleteButton.addActionListener(e -> {
            String bookName = nameTF.getText();
            //remove book entry in book register
            BookRegisterEntry bookEntry = BookRegister.INSTANSE.getEntry(bookName);
            if (bookEntry == null) {
                JOptionPane.showMessageDialog(this,
                        "Книга " + bookName + " не найдена в каталоге");
                return;
            }
            BookRegister.INSTANSE.delete(bookEntry);
            //remove book place in book storage
            BookPlace bookPlace = BookStorage.INSTANCE.getBookPlace(bookName);
            if (bookPlace == null) {
                JOptionPane.showMessageDialog(this,
                        "Книга " + bookName + " не найдена в хранилище");
            } else {
                //delete visitors entry from visitors register
                VisitorsRegisterEntry entry = VisitorsRegister.INSTANCE.getEntry(bookPlace.getBook());
                while (entry != null) {
                    VisitorsRegister.INSTANCE.delete(entry);
                    entry = VisitorsRegister.INSTANCE.getEntry(bookPlace.getBook());
                }
            }
            //delete book from users lists
            Visitor visitor;
            for (int i = 0; i < VisitorsProfiles.INSTANCE.getVisitorAmount(); i++) {
                visitor = VisitorsProfiles.INSTANCE.getVisitor(i);
                VisitorsProfiles.INSTANCE.changeVisitor(visitor);
            }
            dispose();
        });


        setLayout( new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(inputPanel);
        getContentPane().add(deleteButton);
        pack();
        setVisible(true);
    }
}
