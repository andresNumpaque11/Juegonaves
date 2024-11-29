package com.edu.uptc.views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.util.ArrayList;

public class ViewGame extends JFrame {
    private PanelGame panelGame;
    private PanelInfoGame panelInfoGame;
    private ImageIcon image;
    private GameOver gameOver;

    public ViewGame(IinitialSettingsGame iinitialSettingsGame) {
        super("Ovnis al escape");
        initComponents(iinitialSettingsGame);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(false);
        this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        this.setUndecorated(false);

    }

    private void initComponents(IinitialSettingsGame iinitialSettingsGame) {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        image = new ImageIcon("naves/src/resources/fondo4.jpg");
        Image background = image.getImage();
        panelGame = new PanelGame(background, iinitialSettingsGame);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.weightx = 0.8;
        gbc.weighty = 0.9;
        gbc.fill = GridBagConstraints.BOTH;
        add(panelGame, gbc);

        panelInfoGame = new PanelInfoGame();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 0.2;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        add(panelInfoGame, gbc);
        gameOver = new GameOver(iinitialSettingsGame);


    }

    public void setPos(ArrayList<Integer> xs, ArrayList<Integer> ys) {
        panelGame.setPositions(xs, ys);
    }
    public  void ejecuteGameOver(boolean b){
        gameOver.setVisible(b);
    }

    public void refreshGame() {
        panelGame.repaint();
    }

    public PanelGame getPanelGame() {
        return panelGame;
    }

    public PanelInfoGame getPanelInfoGame() {
        return panelInfoGame;
    }
}
