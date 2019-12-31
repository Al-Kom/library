package by.bsuir.ankomar.library.view;

import by.bsuir.ankomar.library.controller.BookRegister;
import by.bsuir.ankomar.library.enums.UserStatus;
import by.bsuir.ankomar.library.model.Book;
import by.bsuir.ankomar.library.model.BookRegisterEntry;
import by.bsuir.ankomar.library.model.FinishedBook;
import by.bsuir.ankomar.library.model.Visitor;

import javax.swing.*;
import java.awt.*;
import java.util.List;


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
        addToFavourite.addActionListener(e -> {
            String bookName = JOptionPane.showInputDialog(this,
                    "Введите название книги");
            BookRegisterEntry entry = BookRegister.INSTANSE.getEntry(bookName);
            if (entry == null) {
                JOptionPane.showMessageDialog(this,
                        "Книга не найдена");
            } else {
                Book book = entry.book;
                List<Book> favourite = visitor.getFavouriteBooks();
                visitor.addToList(favourite, book);
            }
        });

        addToPlanned.addActionListener(e -> {
            String bookName = JOptionPane.showInputDialog(this,
                    "Введите название книги");
            BookRegisterEntry entry = BookRegister.INSTANSE.getEntry(bookName);
            if (entry == null) {
                JOptionPane.showMessageDialog(this,
                        "Книга не найдена");
            } else {
                Book book = entry.book;
                List<Book> planned = visitor.getPlannedBooks();
                visitor.addToList(planned, book);
            }
        });

        addToFinished.addActionListener(e -> {
            String bookName = JOptionPane.showInputDialog(this,
                    "Введите название книги");
            BookRegisterEntry entry = BookRegister.INSTANSE.getEntry(bookName);
            if (entry == null) {
                JOptionPane.showMessageDialog(this,
                        "Книга не найдена");
            } else {
                String stringRating = JOptionPane.showInputDialog(this,
                        "Поставьте оценку книге");
                int rating = 0;
                try { rating = Integer.valueOf(stringRating); } catch (NumberFormatException ex) {}
                Book book = entry.book;
                List<FinishedBook> finished = visitor.getFinishedBooks();
                visitor.addToList(finished, new FinishedBook(book, rating));
            }
        });

        removeFromPlanned.addActionListener(e -> {
            String bookName = JOptionPane.showInputDialog(this,
                    "Введите название книги");
            List<Book> planned = visitor.getPlannedBooks();
            for (int i = 0; i < planned.size(); i++) {
                if (planned.get(i).name.equals(bookName)) {
                    visitor.deleteFromList(planned, planned.get(i));
                }
            }
        });

        removeFromFavourite.addActionListener(e -> {
            String bookName = JOptionPane.showInputDialog(this,
                    "Введите название книги");
            List<Book> favourite = visitor.getFavouriteBooks();
            for (int i = 0; i < favourite.size(); i++) {
                if (favourite.get(i).name.equals(bookName)) {
                    visitor.deleteFromList(favourite, favourite.get(i));
                }
            }
        });

        removeFromFinished.addActionListener(e -> {
            String bookName = JOptionPane.showInputDialog(this,
                    "Введите название книги");
            List<FinishedBook> finished = visitor.getFinishedBooks();
            for (int i = 0; i < finished.size(); i++) {
                if (finished.get(i).book.name.equals(bookName)) {
                    visitor.deleteFromList(finished, finished.get(i));
                }
            }
        });


        //run dialog
        setLayout( new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(profilePanel);
        getContentPane().add(panel);
        pack();
        setVisible(true);
    }
}
