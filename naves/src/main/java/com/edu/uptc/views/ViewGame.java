package com.edu.uptc.views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

public class ViewGame extends JFrame {
    private PanelGame panelGame;
    private PanelInfoGame panelInfoGame;
    private PanelTittle panelTittle;
    private ImageIcon image;

    public ViewGame() {
        super("Ovnis al escape");
        initComponents();
        this.setSize(1280, 720);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
    }

    private void initComponents() {
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        panelTittle = new PanelTittle();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.weightx = 1.0;
        gbc.weighty = 0.1;
        gbc.fill = GridBagConstraints.BOTH;
        add(panelTittle, gbc);

        image = new ImageIcon("src/resources/fondo4.jpg");
        Image background = image.getImage();
        panelGame = new PanelGame(background);
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

    }

    public void setPos(int x, int y) {
        panelGame.getPosOvni().setLocation(x, y);

    }
}
