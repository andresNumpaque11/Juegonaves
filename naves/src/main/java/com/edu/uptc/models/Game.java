package com.edu.uptc.models;

import com.edu.uptc.interfaces.ModelInterface;
import com.edu.uptc.interfaces.PresenterInterface;

public class Game implements ModelInterface {

    private PresenterInterface presenter;

    @Override
    public void setPresenter(PresenterInterface presenter) {
        this.presenter = presenter;
    }

    

}
