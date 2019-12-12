package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Option extends JFrame implements ActionListener {

    private JButton single;
    private JButton file;

    public Option() {
        single = new JButton("Single Search");
        file = new JButton("File Search (CSV)");

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        setTitle("Single or Multi");
        setSize(800, 600);
        setVisible(true);

        panel.add(single);
        panel.add(file);

        gbc.gridx = 3;
        gbc.gridy = 6;
        panel.add(single, gbc);
        gbc.gridx = 3;
        gbc.gridy = 8;
        panel.add(file, gbc);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == single){
            new StockSearch();
        } else {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
            int result = fileChooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                System.out.println("Selected file: " + selectedFile.getAbsolutePath());
                new StockFile(selectedFile.getAbsolutePath());
                this.dispose();
            }
        }
    }
}