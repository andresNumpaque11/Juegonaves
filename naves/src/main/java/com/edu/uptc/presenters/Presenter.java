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
                    ArrayList<Integer> xs = new ArrayList<>();
                    ArrayList<Integer> ys = new ArrayList<>();
                    for (Ovni ovni : model.getOvnis()) {
                        xs.add(ovni.getCoordinates().getX());
                        ys.add(ovni.getCoordinates().getY());
                        System.out.println(xs + " , " + ys);
                    }
                    view.setPoints(xs, ys);
                    Thread.sleep(100);

                }
            } catch (Exception e) {
            }
        });
        hilo.start();
    }

    public void setPositionsOvni() {
        model.setPositionsOvni();

    }

    public void updateTrajectory(int ovniIndex, ArrayList<Point> trajectory) {
        ArrayList<Coordinates> coordinates = new ArrayList<>();
        for (Point point : trajectory) {
            coordinates.add(new Coordinates((int) point.getX(), (int) point.getY()));
        }
        model.getOvnis().get(ovniIndex).setTrajectory(coordinates);
        System.out.println("se le cambio de trayectoria");
    }

}
