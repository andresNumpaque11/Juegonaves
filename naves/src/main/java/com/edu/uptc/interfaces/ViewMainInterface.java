package com.edu.uptc.interfaces;

import java.util.ArrayList;

import com.edu.uptc.views.IinitialSettingsGame;

public interface ViewMainInterface {
    public void setPresenter(PresenterInterface presenter);

    public void run();

    public int getHeight();

    public int getWidth();

    public void setPoints(ArrayList<Integer> xs, ArrayList<Integer> ys);

    public IinitialSettingsGame getSettingsGame();

    public int getPanelWidth();
    public int getPanelHeight();

}
