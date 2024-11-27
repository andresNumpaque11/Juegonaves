package com.edu.uptc.interfaces;

import java.util.ArrayList;

import com.edu.uptc.models.Ovni;

public interface ModelInterface {
    public void setPresenter(PresenterInterface presenter);

    public void start();

    public void startGame(int numOvnis, int timeappeared, int speed);

    public void calculateRefreshOvnis();

    public void setPositionsOvni();

    public ArrayList<Ovni> getOvnis();

}
