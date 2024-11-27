package com.edu.uptc.models;

import java.util.ArrayList;

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
            try {
                while (numOvnis > ovnis.size()) {
                    ovnis.add(new Ovni(maxheight, maxwidth, speed));
                    System.out.println(ovnis.size());
                    Thread.sleep(timeappeared * 1000);
                }
            } catch (Exception e) {
            }
        });
        creationGame.start();
    }

    public void setPositionsOvni() {
        System.out.println("setiando posiciones...");
        for (Ovni ovni : ovnis) {
            System.out.println(ovni.getCoordinates().getX() + " , " + ovni.getCoordinates().getY());
        }
    }

    public void calculateRefreshOvnis() {
        ArrayList<Ovni> toRemove = new ArrayList<>();
        for (Ovni ovni : ovnis) {
            refreshOvni(ovni);
            if (isOutOfBounds(ovni)) {
                System.out.println("ovni eliminado");
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

    public void removeOvni(Ovni ovni) {
        ovnis.remove(ovni);
    }

    public void checkCollisions() {
        ArrayList<Ovni> toRemove = new ArrayList<>();

        for (int i = 0; i < ovnis.size(); i++) {
            for (int j = i + 1; j < ovnis.size(); j++) {
                Ovni ovni1 = ovnis.get(i);
                Ovni ovni2 = ovnis.get(j);

                if (isColliding(ovni1, ovni2)) {
                    toRemove.add(ovni1);
                    toRemove.add(ovni2);
                    System.out.println("2 ovnis chocaron");
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
        return distance <= collisionDistance;
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

}
