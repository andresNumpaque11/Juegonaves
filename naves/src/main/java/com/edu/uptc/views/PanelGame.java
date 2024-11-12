package com.edu.uptc.views;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class PanelGame extends JPanel {
    private Image backgroundImage;
    private ImageIcon imageOvni;
    private Point posOvni;
    private ArrayList<Integer> xs;
    private ArrayList<Integer> ys;
    private ArrayList<Point> pathPoints;

    public PanelGame(Image backgroundImage) {
        this.setBackground(Color.decode("#4e0196"));
        this.backgroundImage = backgroundImage;
        posOvni = new Point();
        imageOvni = new ImageIcon("naves/src/resources/ovni1.png");
        pathPoints = new ArrayList<>();

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                pathPoints.add(e.getPoint());
                repaint();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                // selectOvni(event.getPoint());
            }
        });
    }

    /*
     * public Point selectOvni(Point clickPoint) {
     * double ovniX = 0;
     * double ovniY = 0;
     * int tolerance = 20;
     * System.out.println("seleccionando ovnis ");
     * for (int i = 0; i < xs.size(); i++) {
     * for (int j = 0; j < ys.size(); j++) {
     * ovniX = (int) xs.get(i);
     * ovniY = ys.get(j);
     * double distance = Math
     * .sqrt(Math.pow(clickPoint.getX() - ovniX, 2) + Math.pow(clickPoint.getY() -
     * ovniY, 2));
     * if (distance <= tolerance) {
     * 
     * }
     * }
     * }
     * 
     * }
     */
    public void setPositions(ArrayList<Integer> xs, ArrayList<Integer> ys) {
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
        paintPath(g);
    }

    public void paintOvni(Graphics g, Point ovni) {
        for (int index = 0; index < xs.size(); index++) {
            imageOvni.paintIcon(this, g, xs.get(index), ys.get(index));
        }
    }

    private void paintPath(Graphics g) {
        g.setColor(Color.YELLOW);
        for (int i = 1; i < pathPoints.size(); i++) {
            Point p1 = pathPoints.get(i - 1);
            Point p2 = pathPoints.get(i);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
}
