package com.edu.uptc.views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelGame extends JPanel {
    private Image backgroundImage;
    private ImageIcon imageOvni;
    private Point posOvni;

    public PanelGame(Image backgroundImage) {
        this.setBackground(Color.decode("#4e0196"));
        this.backgroundImage = backgroundImage;
        posOvni = new Point();
        imageOvni = new ImageIcon("src/resources/ovni1.png");
    }

    public void setPosOvni(int x, int y) {
        posOvni.setLocation(x, y);
    }

    public Point getPosOvni() {
        return posOvni;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        g.drawImage(backgroundImage, 0, 0, width, height, this);
        paintOvni(g, posOvni);
        System.out.println("en la vista:" + posOvni.getX() + " , " + posOvni.getY());
    }

    public void paintOvni(Graphics g, Point ovni) {
        imageOvni.paintIcon(this, g, (int) ovni.getX(), (int) ovni.getY());

    }

}
