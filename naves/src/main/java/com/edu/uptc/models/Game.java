package com.edu.uptc.models;

import java.util.ArrayList;
import java.util.List;

import com.edu.uptc.interfaces.ModelInterface;
import com.edu.uptc.interfaces.PresenterInterface;

public class Game implements ModelInterface {

    private PresenterInterface presenter;
    private ArrayList<Ovni> ovnis;
    private int maxheight;
    private int maxwidth;

    public Game(int maxheight, int maxwidth) {
        this.maxheight = maxheight;
        this.maxwidth = maxwidth;
    }

    @Override
    public void startGame(int numOvnis, int timeappeared, int speed) {
        ovnis = new ArrayList<Ovni>();
        Thread creationGame = new Thread(() -> {
            int f = 0;
            try {
                while (numOvnis > f) {
                    ovnis.add(new Ovni(maxheight, maxwidth, speed));
                    f++;
                    Thread.sleep(timeappeared * 1000);
                    System.out.println("ovni creado " + f);
                }
            } catch (Exception e) {
            }
        });
        creationGame.start();
    }

    public void calculateRefreshOvnis() {
        ArrayList<Ovni> toRemove = new ArrayList<>();
        for (Ovni ovni : ovnis) {
            refreshOvni(ovni);
            if (isOutOfBounds(ovni)) {
                System.out.println("ovni salio");
                toRemove.add(ovni);
            }
        }
        ovnis.removeAll(toRemove);
        checkCollisions();
    }

    private boolean isOutOfBounds(Ovni ovni) {
        Coordinates coordinates = ovni.getCoordinates();
        int x = coordinates.getX();
        int y = coordinates.getY();
        return x < 0 || x > maxwidth || y < 0 || y > maxheight;
    }

    public void refreshOvni(Ovni ovni) {
        Coordinates coordinates = ovni.getCoordinates();
        double x = coordinates.getX() + ovni.getSpeed() * Math.cos(Math.toRadians(ovni.getAngle()));
        double y = coordinates.getY() + ovni.getSpeed() * Math.sin(Math.toRadians(ovni.getAngle()));
        ovni.setCoordinates(new Coordinates((int) x, (int) y));
    }

    public void collisionWhitchPlanet(int planetX, int planetY, int planetDiameter) {
        ArrayList<Ovni> toRemove = new ArrayList<>();

        for (Ovni ovni : ovnis) {
            if (isCollidingWithPlanet(ovni, planetX, planetY, planetDiameter)) {
                toRemove.add(ovni);
                System.out.println("Ovni colisionó con el planeta.");
            }
        }

        ovnis.removeAll(toRemove);
    }

    private boolean isCollidingWithPlanet(Ovni ovni, int planetX, int planetY, int planetDiameter) {
        Coordinates ovniCoordinates = ovni.getCoordinates();
        int ovniDiameter = 50;

        int ovniCenterX = ovniCoordinates.getX() + ovniDiameter / 2;
        int ovniCenterY = ovniCoordinates.getY() + ovniDiameter / 2;

        int planetCenterX = planetX + planetDiameter / 2;
        int planetCenterY = planetY + planetDiameter / 2;

        double distance = Math.sqrt(
                Math.pow(ovniCenterX - planetCenterX, 2) + Math.pow(ovniCenterY - planetCenterY, 2));
        return distance <= (ovniDiameter / 2 + planetDiameter / 2);
    }

    public void removeOvni(Ovni ovni) {
        ovnis.remove(ovni);
    }

    public void checkCollisions() {
        List<Ovni> toRemove = new ArrayList<>();

        for (int i = 0; i < ovnis.size(); i++) {
            for (int j = i + 1; j < ovnis.size(); j++) {
                Ovni ovni1 = ovnis.get(i);
                Ovni ovni2 = ovnis.get(j);
                if (ovni1 != ovni2 && isColliding(ovni1, ovni2)) {
                    System.out.println("2 ovnis chocaron i:" + i + " j:" + j);
                    System.out.println("Los ovnis a eliminar son " +
                            ovni1.getCoordinates().getX() + "x" + ovni1.getCoordinates().getY() +
                            " y el ovni " +
                            ovni2.getCoordinates().getX() + "x" + ovni2.getCoordinates().getY());
                    if (!toRemove.contains(ovni1))
                        toRemove.add(ovni1);
                    if (!toRemove.contains(ovni2))
                        toRemove.add(ovni2);
                }
            }
        }

        ovnis.removeAll(toRemove);
    }

    private boolean isColliding(Ovni ovni1, Ovni ovni2) {
        Coordinates c1 = ovni1.getCoordinates();
        Coordinates c2 = ovni2.getCoordinates();

        double distance = Math.sqrt(
                Math.pow(c2.getX() - c1.getX(), 2) + Math.pow(c2.getY() - c1.getY(), 2));

        double collisionDistance = 50;
        if (distance <= collisionDistance) {
            System.out.println("distancia " + distance + " y la colision debe ser " + collisionDistance);
            return true;
        } else {
            return false;
        }
        // return distance <= collisionDistance;
    }

    @Override
    public void setPresenter(PresenterInterface presenter) {
    }

    public PresenterInterface getPresenter() {
        return presenter;
    }

    @Override
    public ArrayList<Ovni> getOvnis() {
        return ovnis;
    }

    @Override
    public void start() {
    }

    public int getMaxheight() {
        return maxheight;
    }

    public int getMaxwidth() {
        return maxwidth;
    }

}
