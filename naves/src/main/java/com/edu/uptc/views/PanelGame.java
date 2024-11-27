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
    private int ovniSelected;
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
                repaint();
            }
        });
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent event) {
                selectOvni(event.getPoint());

            }
        });
    }

    public void selectOvni(Point clickPoint) {
        for (int i = 0; i < xs.size(); i++) {
            int ovnix = xs.get(i);
            int ovniy = ys.get(i);
            int diameter = 64;
            if (Math.abs(clickPoint.getX() - ovnix) <= diameter / 2 &&
                    Math.abs(clickPoint.getY() - ovniy) <= diameter / 2) {
                System.out.println("ovni seleccionado en " + ovnix + " ," + ovniy);
                this.trajectory = new ArrayList<>(pathPoints);
                ovniSelected = i;

                pathPoints.clear();
                updateOvniTrajectory(i, trajectory);
                repaint();
            }
        }
        System.out.println("accion de click en " + clickPoint.getX() +
                " , " + clickPoint.getY());

    }

    public void updateOvniTrajectory(int ovniIndex, ArrayList<Point> trajectory) {
        System.out.println("cambiando trayectoria");
        iinitialSettingsGame.updateOvniTrajectory(ovniIndex, trajectory);
    }

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

    public int getOvniSelected() {
        return ovniSelected;
    }
}
