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
    private ImageIcon imagePlanet;
    private ArrayList<Integer> xs;
    private ArrayList<Integer> ys;
    private ArrayList<Point> pathPoints;
    private ArrayList<Point> trajectory;
    private IinitialSettingsGame iinitialSettingsGame;

    public PanelGame(Image backgroundImage, IinitialSettingsGame iinitialSettingsGame) {
        this.setBackground(Color.decode("#4e0196"));
        this.backgroundImage = backgroundImage;
        posOvni = new Point();
        imageOvni = new ImageIcon("naves/src/resources/ovni1.png");
        imagePlanet = new ImageIcon("naves/src/resources/meta.png");
        pathPoints = new ArrayList<>();
        this.iinitialSettingsGame = iinitialSettingsGame;
        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                pathPoints.add(e.getPoint());
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                selectOvni(pathPoints.get(0));
                pathPoints.clear();
            }
        });
    }

    public void selectOvni(Point clickPoint) {
        for (int i = 0; i < xs.size(); i++) {
            int ovnix = xs.get(i);
            int ovniy = ys.get(i);
            int diameter = 100;
            if (Math.abs(clickPoint.getX() - ovnix) <= (diameter / 2) &&
                    Math.abs(clickPoint.getY() - ovniy) <= (diameter / 2)) {
                
                ArrayList<Point> trajectoryCopy = new ArrayList<>(pathPoints);
                
                updateOvniTrajectory(i, trajectoryCopy);
                pathPoints.clear();
            }
        }
    }   
    

    public void updateOvniTrajectory(int ovniIndex, ArrayList<Point> trajectory) {
        iinitialSettingsGame.updateOvniTrajectory(ovniIndex, trajectory);
    }

    public void setPositions(ArrayList<Integer> xs, ArrayList<Integer> ys) {
        this.xs = xs;
        this.ys = ys;
        repaint();
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        g.drawImage(backgroundImage, 0, 0, width, height, this);
        paintOvni(g, posOvni);
        paintPlanet(g);
        paintPath(g);
    }

    public void paintOvni(Graphics g, Point ovni) {
        for (int index = 0; index < xs.size(); index++) {
            imageOvni.paintIcon(this, g, xs.get(index), ys.get(index));
        }
    }    

    public void paintPlanet(Graphics g) {
        imagePlanet.paintIcon(this, g, this.getWidth() - 128, this.getHeight() - 128);
    }
    public int getXplanet(){
        return this.getWidth()-128;
    }
    public int getYplanet(){
        return this.getHeight()-128;
    }

    private void paintPath(Graphics g) {
        g.setColor(Color.YELLOW);
        for (int i = 1; i < pathPoints.size(); i++) {
            Point p1 = pathPoints.get(i - 1);
            Point p2 = pathPoints.get(i);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }

    public ArrayList<Point> getTrajectory() {
        return trajectory;
    }
}
