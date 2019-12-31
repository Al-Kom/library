package by.bsuir.ankomar.library.view;

import by.bsuir.ankomar.library.connector.UsersConnector;
import by.bsuir.ankomar.library.controller.BookRegister;
import by.bsuir.ankomar.library.controller.VisitorsRegister;
import by.bsuir.ankomar.library.model.BookRegisterEntry;
import by.bsuir.ankomar.library.model.Visitor;
import by.bsuir.ankomar.library.model.VisitorsRegisterEntry;

import javax.swing.*;
import java.awt.*;


public class ReturnBookGui extends JDialog {

    public ReturnBookGui(JFrame parent, Visitor visitor) {
        super(parent,"Вернуть книгу");

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
        JLabel bookNameLabel = new JLabel("Название книги");
        JTextField bookNameTF = new JTextField();
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(1,2));
        inputPanel.add(bookNameLabel);
        inputPanel.add(bookNameTF);

        //'return' button
        JButton returnButton = new JButton("Вернуть");
        returnButton.addActionListener(e -> {
            String bookName = bookNameTF.getText();
            //search book entry in book register
            BookRegisterEntry bookEntry = BookRegister.INSTANSE.getEntry(bookName);
            if (bookEntry == null) {
                JOptionPane.showMessageDialog(this,
                        "Книга " + bookName + " не найдена в каталоге");
                return;
            }
            //edit visitors entry
            VisitorsRegisterEntry entry  = VisitorsRegister.INSTANCE.getEntry(bookEntry.book);
            if (entry == null) {
                JOptionPane.showMessageDialog(this,
                        "Книга " + bookName + " не найдена в учете");
            } else {
                JOptionPane.showMessageDialog(this,
                        "Книга " + bookName + " найдена.\n" +
                                "Запрос на возврат будет отправлен владельцу");
                //take book
                ownerGui.showReturnBook(visitor, entry);
            }
            dispose();
        });

        //run gui
        setLayout( new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(inputPanel);
        getContentPane().add(returnButton);
        pack();
        setVisible(true);
    }
}
