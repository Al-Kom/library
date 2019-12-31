package by.bsuir.ankomar.library.view;

import by.bsuir.ankomar.library.connector.UsersConnector;
import by.bsuir.ankomar.library.controller.BookRegister;
import by.bsuir.ankomar.library.controller.BookStorage;
import by.bsuir.ankomar.library.controller.VisitorsProfiles;
import by.bsuir.ankomar.library.enums.BookStatus;
import by.bsuir.ankomar.library.model.BookRegisterEntry;
import by.bsuir.ankomar.library.model.Visitor;

import javax.swing.*;
import java.awt.*;

public class TakeBookDialog extends JDialog {

    public TakeBookDialog(Frame parent, Visitor visitor) {
        super(parent,"Поиск книги");

        //check if owner exists
        OwnerGui ownerGui = UsersConnector.INSTANCE.getOwnerGui();
        if (ownerGui == null) {
            JOptionPane.showMessageDialog(parent,
                    "Владелец не обнаружен!",
                    "Ошибка",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        //input panel
        JPanel inputPanel = new JPanel();
        JLabel nameLabel = new JLabel("Название книги");
        JTextField nameTF = new JTextField();
        inputPanel.setLayout( new GridLayout(1, 2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameTF);

        //button panel
        JButton searchButton = new JButton("Поиск");
        searchButton.addActionListener(e -> {
            String bookName = nameTF.getText();
            //search book entry in book register
            BookRegisterEntry entry = BookRegister.INSTANSE.getEntry(bookName);
            if (entry == null) {
                JOptionPane.showMessageDialog(this,
                        "Книга " + bookName + " не найдена в каталоге");
                return;
            }
            if (entry.getStatus() == BookStatus.BORROWED) {
                int userInput = JOptionPane.showConfirmDialog(this,
                        "Книга " + bookName + " \"на руках\"\n" +
                                "Хотите добавить к запланированным?",
                        "",
                        JOptionPane.YES_NO_OPTION);
                if (userInput == JOptionPane.YES_OPTION) {
                    //add to planned
                    VisitorsProfiles.INSTANCE.changeVisitor(visitor);
                }
            } else if (BookStorage.INSTANCE.getBookPlace(bookName)!=null) { //search book place in book storage
                JOptionPane.showMessageDialog(this,
                        "Книга " + bookName + " найдена.\n" +
                                "Запрос на взятие будет отправлен владельцу");
                //take book
                ownerGui.showTakeBook(visitor, entry);
            }
        });

        setLayout( new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(inputPanel);
        getContentPane().add(searchButton);
        pack();
        setVisible(true);
    }
}
