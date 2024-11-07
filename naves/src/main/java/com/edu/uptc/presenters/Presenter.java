package com.edu.uptc.presenters;

import com.edu.uptc.interfaces.ModelInterface;
import com.edu.uptc.interfaces.PresenterInterface;
import com.edu.uptc.interfaces.ViewInterface;

public class Presenter implements PresenterInterface {

    private ViewInterface view;
    private ModelInterface model;

    public Presenter() {

    }

    @Override
    public void setView(ViewInterface view) {
        this.view = view;
    }

    @Override
    public void setModel(ModelInterface model) {
        this.model = model;
    }

    public ModelInterface getModel() {
        return model;
    }

    public ViewInterface getView() {
        return view;
    }
    public void startGame(){
        model.startGame(2, 2);
    }

    @Override
    public void start() {
        model.start();
    }

}
