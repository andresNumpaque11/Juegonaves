package com.edu.uptc.models;

import java.util.ArrayList;

import com.edu.uptc.interfaces.ModelInterface;
import com.edu.uptc.interfaces.PresenterInterface;

public class Game implements ModelInterface {

    private PresenterInterface presenter;
    private Ovni ovni;
    private ArrayList<Ovni> ovnis;

    public Game() {
        ovni = new Ovni();
    }

    @Override
    public void startGame(int numOvnis, int timeappeared) {
        while (numOvnis > ovnis.size()) {
            ovnis.add(new Ovni());

            try {
                Thread.sleep(timeappeared * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void setPresenter(PresenterInterface presenter) {
    }

    public PresenterInterface getPresenter() {
        return presenter;
    }

    @Override
    public void start() {
        ovni.start();
        int x = ovni.getCoordinates().getX();
        int y = ovni.getCoordinates().getY();
        System.out.println(x + ", " + y);

    }

}
