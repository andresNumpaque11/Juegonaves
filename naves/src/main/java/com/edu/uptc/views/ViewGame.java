package com.edu.uptc.views;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.util.ArrayList;

public class ViewGame extends JFrame {
    private PanelGame panelGame;
    private PanelInfoGame panelInfoGame;
    private ImageIcon image;
    private GameOver gameOver;

    public ViewGame(IinitialSettingsGame iinitialSettingsGame,int width, int height) {
        super("Ovnis al escape");
        initComponents(iinitialSettingsGame);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(false);
        this.setSize(width, height);
        System.out.println(this.getSize().height+"ancho"+this.getSize().getWidth());
        this.setUndecorated(false);

    }

    private void initComponents(IinitialSettingsGame iinitialSettingsGame) {
        this.setLayout(new BorderLayout());
        image = new ImageIcon("naves/src/resources/fondo4.jpg");
        Image background = image.getImage();
        panelGame = new PanelGame(background, iinitialSettingsGame);
        this.add(panelGame, BorderLayout.CENTER); 
        panelInfoGame = new PanelInfoGame();
        panelInfoGame.setPreferredSize(new Dimension(300, 0));
        this.add(panelInfoGame, BorderLayout.EAST);
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
