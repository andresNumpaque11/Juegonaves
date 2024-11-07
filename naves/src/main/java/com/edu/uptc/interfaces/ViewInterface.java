package com.edu.uptc.interfaces;

import java.util.ArrayList;

public interface ViewInterface {
    public void setPresenter(PresenterInterface presenter);

    public int getSpeedOvni();

    public void setpos(ArrayList<Integer> xs, ArrayList<Integer> ys);

    public void run();
}
