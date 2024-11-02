package com.edu.uptc.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.edu.uptc.interfaces.PresenterInterface;
import com.edu.uptc.interfaces.ViewInterface;

public class Splash extends JFrame implements ViewInterface {

    private PresenterInterface presenter;
    private JButton startGame;
    private JLabel welcomeLabel;

    public Splash() {
        super("Naves XD");
        this.setSize(500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        welcomeLabel = new JLabel("Naves XD");
        welcomeLabel.setBounds(220, 10, 100, 50);
        
        add(welcomeLabel);
        addButtonStartGame();
        
    }
    private void addButtonStartGame(){
        startGame = new JButton("Iniciar Juego");
        startGame.setBounds(190, 140, 150, 50);
        startGame.addActionListener(new  ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("hola Mundo");
            }
            
        });
        this.add(startGame);

    }

    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public void run() {
        initComponents();
        this.setVisible(true);

    }

}
