package com.companyLaura;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JFrame implements ActionListener {

    JButton button;
    JTextField textField;

    MyFrame() {

        this.setTitle("TO-DO LIST");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());

        button = new JButton("saglabāt");                               //definēt pogu uzreiz ar uzrakstu
        button.addActionListener(this);

        textField = new JTextField();
        textField.setPreferredSize(new Dimension(300, 40));     //teksta lodziņa izmērs
        textField.setFont(new Font("Consolas", Font.BOLD, 25));   //burti lodziņā
        textField.setForeground(new Color(0x99004C));                   //teksta krāsa
        textField.setBackground(new Color(0xE0E0E0));                   //mazā lodziņa fona krāsa
        //textField.setCaretColor(Color.white);                             //kursors
        //textField.setText("username");                                    //var uzlikt kādu tekstu jau iepriekš
        //textField.setEditable(false);                                     //nedrīkst labot ievadīto tekstu

        this.add(button);                                                   //pievienot pogu
        this.add(textField);                                                //pievienot teksta ievades lauciņu
        this.pack();
        this.setResizable(false);                                           //ļaut mainīt izmēru frame
        this.setSize(500, 300);                                 //frame izmēri
        this.setVisible(true);                                              //uzlikt frame redzamu

        ImageIcon image = new ImageIcon("smile.png");                   //frame ikona
        this.setIconImage(image.getImage());                                    //frame ikonas bilde
        this.getContentPane().setBackground(new Color(255, 204, 229));  //frame fona  krāsa
    }

    @Override
    public void actionPerformed(ActionEvent x) {
        if(x.getSource()==button) {
            System.out.println(textField.getText());
        }
    }
}
