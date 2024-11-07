package com.edu.uptc.views;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.edu.uptc.interfaces.PresenterInterface;
import com.edu.uptc.interfaces.ViewInterface;

public class Splash extends JFrame implements ViewInterface {

    private PresenterInterface presenter;
    private JButton startGame;
    private JLabel welcomeLabel;
    private IinitialSettingsGame settingsGame;
    private ViewGame viewGame;
    private Background background;
    private ImageIcon fondo;

    public Splash() {
        super("Ovnis al escape");
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
    }

    private void initComponents() {
        fondo = new ImageIcon("src/resources/fondoSplash.jpeg");
        Image backImage = fondo.getImage();
        background = new Background(backImage);
        background.setBounds(0, 0, this.getWidth(), this.getHeight());
        add(background);
        welcomeLabel = new JLabel("Ovnis al escape!!");
        welcomeLabel.setBounds(220, 10, 100, 50);

        add(welcomeLabel);
        addButtonStartGame();
        settingsGame = new IinitialSettingsGame();

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

    public PresenterInterface getPresenter() {
        return presenter;
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

    @Override
    public int getSpeedOvni() {
        return Integer.parseInt(settingsGame.getTxtVelocity().getText());
    }

    @Override
    public void setpos(int x, int y) {
        viewGame.setPos(x, y);
    }


}
