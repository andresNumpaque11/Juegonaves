package com.edu.uptc.interfaces;

public interface PresenterInterface {
    public void setView(ViewMainInterface view);

    public void setModel(ModelInterface model);

    public void startGame(int numOvnis, int timeappeared, int speed);

}
