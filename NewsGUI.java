package com.newsaggregator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class NewsGUI extends JFrame {
    private JTextArea area;
    private JButton loadButton;

    public NewsGUI() {
        setTitle("News Aggregator");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        area = new JTextArea();
        loadButton = new JButton("Load News");

        loadButton.addActionListener(e -> area.setText("Displaying News..."));

        add(new JScrollPane(area), BorderLayout.CENTER);
        add(loadButton, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new NewsGUI().setVisible(true));
    }
}


