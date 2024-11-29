package com.edu.uptc.views;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.edu.uptc.interfaces.PresenterInterface;
import com.edu.uptc.interfaces.ViewMainInterface;

public class Splash extends JFrame implements ViewMainInterface {

    private JButton startGame;
    private JLabel welcomeLabel;
    private IinitialSettingsGame settingsGame;
    private Background background;
    private ImageIcon fondo;
    private int WIDTH;
    private int HEIGHT;

    public Splash(int width, int height) {
        super("Ovnis al escape");
        this.WIDTH = width;
        this.HEIGHT = height;
        settingsGame = new IinitialSettingsGame(width,height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(width, height);
        this.setUndecorated(false);
        addButtonStartGame();
    }

    private void initComponents() {
        fondo = new ImageIcon("naves/src/resources/fondoSplash.jpeg");
        Image backImage = fondo.getImage();
        background = new Background(backImage);
        background.setBounds(0, 0, this.getWidth(), this.getHeight());
        welcomeLabel = new JLabel("Ovnis al escape!!");
        welcomeLabel.setForeground(Color.white);
        welcomeLabel.setBounds(0, 0, 800, 300);
        this.add(welcomeLabel);
        add(background);
        repaint();
    }

    private void addButtonStartGame() {
        startGame = new JButton("Iniciar Juego");
        startGame.setBounds(190, 140, 150, 50);
        startGame.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                settingsGame.setVisible(true);

            }

        });
        this.add(startGame);

    }

    public IinitialSettingsGame getSettingsGame() {
        return settingsGame;
    }

    @Override
    public void run() {
        this.setVisible(true);
        initComponents();
    }

    @Override
    public void setPresenter(PresenterInterface presenter) {
        settingsGame.setPresenter(presenter);
    }

    public void setPoints(ArrayList<Integer> xs, ArrayList<Integer> ys) {
        settingsGame.setpos(xs, ys);
    }

    @Override
    public int getPanelWidth() {
        return WIDTH;
    }

    @Override
    public int getPanelHeight() {
        return HEIGHT;
    }

}
