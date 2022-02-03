package com.companyLaura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertForm extends JDialog implements ActionListener {
    private JTextField nameField;
    private JTextField termField;
    private JTextField doneField;
    private JTextField commentField;
    private JButton btnPievienot;
    private JButton btnAtcelt;
    private JPanel insertPanel;
    private JPanel leftPanel;


    String DB = "jdbc:mysql://localhost:3302/todolist";
    String USER = "root";
    String PASS = "11.SuNsL";
    static final String QUERY = "SELECT id, name, term, done, comment FROM todo";

    public InsertForm(JFrame parent) {
        super(parent);
        setTitle("TO-DO LIST");
        setContentPane(insertPanel);
        setMinimumSize(new Dimension(750,600));
        setModal(true);
        setLocationRelativeTo(parent);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnPievienot) {
            try(
                    Connection conn = DriverManager.getConnection(DB, USER, PASS);
                    Statement stmt = conn.createStatement()
            ){
                String sql = "INSERT INTO todo (name, term, done, comment) VALUES ('"+nameField.getText()+"','"+termField.getText()
                        +"','"+doneField.getText()+"','"+commentField.getText()+"');";
                stmt.executeUpdate(sql);
                System.out.println("Dati saglabāti!");
            } catch (SQLException x) {
                x.printStackTrace();
            }
        }
    }
}
