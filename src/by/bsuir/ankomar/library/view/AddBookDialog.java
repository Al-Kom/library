package by.bsuir.ankomar.library.view;

import by.bsuir.ankomar.library.controller.BookRegister;
import by.bsuir.ankomar.library.controller.BookStorage;
import by.bsuir.ankomar.library.enums.BookStatus;
import by.bsuir.ankomar.library.enums.Direction;
import by.bsuir.ankomar.library.enums.Jenre;
import by.bsuir.ankomar.library.enums.Theme;
import by.bsuir.ankomar.library.model.Book;
import by.bsuir.ankomar.library.model.BookPlace;
import by.bsuir.ankomar.library.model.BookRegisterEntry;

import javax.swing.*;
import java.awt.*;

public class AddBookDialog extends JDialog {

    public AddBookDialog(JFrame parent) {
        super(parent, "Добавление книги");

        //input panel
        JLabel nameLabel = new JLabel("Название");
        JTextField nameTF = new JTextField();
        JLabel authorLabel = new JLabel("Автор");
        JTextField authorTF = new JTextField();
        JLabel yearLabel = new JLabel("Год издания");
        JTextField yearTF = new JTextField();
        JLabel publishingHouseLabel = new JLabel("Издательство");
        JTextField publishingHouseTF = new JTextField();
        //theme combo box
        JLabel themeLabel = new JLabel("Тематика");
        String[] themes = {"Детская","Художественная","Научная","Образовательная"};
        JComboBox<String> themeCB = new JComboBox<>(themes);
        //optional
        JLabel jenreLabel = new JLabel("Жанр");
        String[] jenres = {"Роман","Детектив","Фэнтэзи","Комикс","Классика","Поэзия"};
        JComboBox<String> jenreCB = new JComboBox<>(jenres);
        JLabel directionLabel = new JLabel("Направление");
        String[] directions = {"Физика","Математика","Биология",
                "Химия","Медицина","Астрономия","Психология"};
        JComboBox<String> directionCB = new JComboBox<>(directions);

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout( new GridLayout(6,2));
        inputPanel.add(nameLabel);
        inputPanel.add(nameTF);
        inputPanel.add(authorLabel);
        inputPanel.add(authorTF);
        inputPanel.add(yearLabel);
        inputPanel.add(yearTF);
        inputPanel.add(publishingHouseLabel);
        inputPanel.add(publishingHouseTF);
        inputPanel.add(themeLabel);
        inputPanel.add(themeCB);

        //theme combo box listener
        themeCB.addActionListener(e -> {
            inputPanel.remove(jenreLabel);
            inputPanel.remove(jenreCB);
            inputPanel.remove(directionLabel);
            inputPanel.remove(directionCB);
            String selected = (String) themeCB.getSelectedItem();
            if (selected.equals("Художественная")) {
                inputPanel.add(jenreLabel);
                inputPanel.add(jenreCB);
            } else if (selected.equals("Научная") || selected.equals("Образовательная")) {
                inputPanel.add(directionLabel);
                inputPanel.add(directionCB);
            }
            inputPanel.updateUI();
        });

        //'add' button
        JButton addButton = new JButton("Добавить");
        addButton.addActionListener(e -> {
            try {
                //create book
                Book book = new Book(nameTF.getText(),
                        authorTF.getText(),
                        Integer.valueOf(yearTF.getText()),
                        publishingHouseTF.getText());
                //add entry to register
                BookRegisterEntry bookEntry = new BookRegisterEntry(book, 0, BookStatus.AVAILABLE);
                BookRegister.INSTANSE.add(bookEntry);
                //add book place to storage
                String selectedTheme = (String) themeCB.getSelectedItem();
                switch (selectedTheme) {
                    case "Художественная":
                        String selectedJenre = (String) jenreCB.getSelectedItem();
                        Jenre jenre = Jenre.CLASSIC;
                        switch (selectedJenre) {
                            case "Роман":
                                jenre = Jenre.NOVEL;
                                break;
                            case "Детектив":
                                jenre = Jenre.DETECTIVE;
                                break;
                            case "Фэнтэзи":
                                jenre = Jenre.FANTASY;
                                break;
                            case "Комикс":
                                jenre = Jenre.COMICS;
                                break;
                            case "Поэзия":
                                jenre = Jenre.POETRY;
                        }
                        BookStorage.INSTANCE.add(new BookPlace(book, Theme.ART, jenre));
                        break;
                    case "Научная":
                    case "Образовательная":
                        String selectedDirection = (String) directionCB.getSelectedItem();
                        Direction direction = Direction.ASTRONOMY;
                        switch (selectedDirection) {
                            case "Биология":
                                direction = Direction.BIOLOGY;
                                break;
                            case "Физика":
                                direction = Direction.PHYSICS;
                                break;
                            case "Математика":
                                direction = Direction.MATHEMATICS;
                                break;
                            case "Химия":
                                direction = Direction.CHEMISTRY;
                                break;
                            case "Медицина":
                                direction = Direction.MEDICINE;
                                break;
                            case "Психология":
                                direction = Direction.PSYCHOLOGY;
                        }
                        BookStorage.INSTANCE.add(new BookPlace(book,
                                (selectedTheme.equals("Научная"))
                                        ? Theme.SCIENTIFIC
                                        : Theme.EDUCATIONAL,
                                direction));
                        break;
                    default:     //children's
                        BookStorage.INSTANCE.add(new BookPlace(book, Theme.CHILDRENS));
                        break;
                }
            } catch (NumberFormatException ex) {
                //print validating error
                JOptionPane.showMessageDialog(parent,
                        "Невалидные данные!",
                        "Ошибка",
                        JOptionPane.ERROR_MESSAGE);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            dispose();
        });

        setLayout( new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        getContentPane().add(inputPanel);
        getContentPane().add(addButton);
        pack();
        setBounds(0,100,300,230);
        setVisible(true);
    }
}
