package com.edu.uptc.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GameOver extends JFrame {

    private JLabel gameOverLabel;
    private JButton toMenuButton;
    private IinitialSettingsGame settingsGame;

    public GameOver(IinitialSettingsGame settingsGame) {
        this.settingsGame = settingsGame;
        setTitle("Juego Terminado");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        initComponents();
        setVisible(false);
    }

    private void initComponents() {
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.BLACK);
        mainPanel.setLayout(null);
        gameOverLabel = new JLabel("GAME OVER");
        gameOverLabel.setForeground(Color.WHITE);
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 30));
        gameOverLabel.setBounds(100, 30, 200, 40);
        mainPanel.add(gameOverLabel);

        toMenuButton = new JButton("Menú Principal");
        toMenuButton.setBounds(125, 100, 150, 30);
        toMenuButton.setBackground(Color.WHITE);
        toMenuButton.setForeground(Color.BLACK);
        toMenuButton.setFocusPainted(false);
        toMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settingsGame.getViewGame().setVisible(false);
                settingsGame.setVisible(true);
                setVisible(false);
            }
        });
        mainPanel.add(toMenuButton);

        add(mainPanel);
    }
}
