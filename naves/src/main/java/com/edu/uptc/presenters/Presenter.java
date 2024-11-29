package com.edu.uptc.presenters;

import java.awt.Point;
import java.util.ArrayList;

import com.edu.uptc.interfaces.ModelInterface;
import com.edu.uptc.interfaces.PresenterInterface;
import com.edu.uptc.interfaces.ViewMainInterface;
import com.edu.uptc.models.Coordinates;
import com.edu.uptc.models.Ovni;

public class Presenter implements PresenterInterface {

    private ViewMainInterface view;
    private ModelInterface model;
    private static final int FRAMETIME = 100;

    public Presenter() {

    }

    @Override
    public void setView(ViewMainInterface view) {
        this.view = view;
    }

    @Override
    public void setModel(ModelInterface model) {
        this.model = model;
    }

    public ModelInterface getModel() {
        return model;
    }

    public ViewMainInterface getView() {
        return view;
    }

    public void startGame(int numOvnis, int timeappeared, int speed) {
        model.startGame(numOvnis, timeappeared, speed);

        Thread hilo = new Thread(() -> {
            try {
                while (true) {
                    view.getSettingsGame().getViewGame().refreshGame();
                    model.calculateRefreshOvnis();
                    model.collisionWhitchPlanet(model.getMaxwidth()-80,model.getMaxheight()-80, 128);
                    ArrayList<Integer> xs = new ArrayList<>();
                    ArrayList<Integer> ys = new ArrayList<>();
                    for (Ovni ovni : model.getOvnis()) {
                        xs.add(ovni.getCoordinates().getX());
                        ys.add(ovni.getCoordinates().getY());
                    }
                    System.out.println(xs);
                    System.out.println(ys);
                    view.setPoints(xs, ys);
                    Thread.sleep(FRAMETIME);
                    
                }
            } catch (Exception e) {
            }
        });
        hilo.start();
    }
    
    public void updateTrajectory(int ovniIndex, ArrayList<Point> trajectory) {
        if (!model.getOvnis().get(ovniIndex).getIsSelected()) {
            Thread hilo = new Thread(() -> {
                try {
                    model.getOvnis().get(ovniIndex).setIsSelected(true);
                    for (int i = 0; i < trajectory.size(); i++) {
                        model.getOvnis().get(ovniIndex)
                        .setCoordinates(
                            new Coordinates((int) trajectory.get(i).getX(),
                            (int) trajectory.get(i).getY()));
                            
                            ArrayList<Integer> xs = new ArrayList<>();
                            ArrayList<Integer> ys = new ArrayList<>();
                            for (Ovni ovni : model.getOvnis()) {
                                xs.add(ovni.getCoordinates().getX());
                                ys.add(ovni.getCoordinates().getY());
                            }
                            view.setPoints(xs, ys);
                            view.getSettingsGame().getViewGame().refreshGame();
                            
                            //Thread.sleep(FRAMETIME / 4);
                            Thread.sleep(10);
                            stopGame();
                    }
                    model.getOvnis().get(ovniIndex).setIsSelected(false);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
            hilo.start();
        }
    }
    public void setInfoOvnis(int info){

    }
    private void stopGame(){
       int numOvnis = model.getOvnis().size();
       if (numOvnis==0) {
        view.getSettingsGame().getViewGame().ejecuteGameOver(true);
        
       } 

    }

}
