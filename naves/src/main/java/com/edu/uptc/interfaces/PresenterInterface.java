package com.edu.uptc.interfaces;

import java.awt.Point;
import java.util.ArrayList;


public interface PresenterInterface {
    public void setView(ViewMainInterface view);

    public void setModel(ModelInterface model);

    public void startGame(int numOvnis, int timeappeared, int speed);

    public void updateTrajectory(int ovniIndex, ArrayList<Point> trajectory);

}
