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
                    ovnis.add(new Ovni(maxheight, maxwidth,speed));
                    Thread.sleep(timeappeared * 1000);
                }
            } catch (Exception e) {
            }
        });
        creationGame.start();
        System.out.println("termine de crear ovnis");
    }

    public void calculateRefreshOvnis(){
        for (Ovni ovni : ovnis) {
            refreshOvni(ovni);
        }
    }

    public void refreshOvni(Ovni ovni){
        Coordinates coordinates = ovni.getCoordinates();
        double x = coordinates.getX()+ovni.getSpeed()*Math.cos(Math.toRadians(ovni.getAngle()));
        double y = coordinates.getY()+ovni.getSpeed()*Math.sin(Math.toRadians(ovni.getAngle()));
        ovni.setCoordinates(new Coordinates((int) x, (int) y));
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
