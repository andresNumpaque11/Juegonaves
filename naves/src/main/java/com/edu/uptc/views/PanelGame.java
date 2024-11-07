package com.edu.uptc.views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class PanelGame extends JPanel {
    private Image backgroundImage;
    private ImageIcon imageOvni;
    private Point posOvni;
    private ArrayList<Integer> xs;
    private ArrayList<Integer> ys;


    public PanelGame(Image backgroundImage) {
        this.setBackground(Color.decode("#4e0196"));
        this.backgroundImage = backgroundImage;
        posOvni = new Point();
        imageOvni = new ImageIcon("naves/src/resources/ovni1.png");
    }

    public void setPositions(ArrayList<Integer> xs, ArrayList<Integer> ys){
        this.xs = xs;
        this.ys = ys;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        g.drawImage(backgroundImage, 0, 0, width, height, this);
        paintOvni(g, posOvni);
    }

    public void paintOvni(Graphics g, Point ovni) {
        for (int index = 0; index < xs.size(); index++) {
            imageOvni.paintIcon(this, g, xs.get(index), ys.get(index));
        }
    }

}
