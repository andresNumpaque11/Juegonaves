package com.edu.uptc.presenters;

import com.edu.uptc.interfaces.ModelInterface;
import com.edu.uptc.interfaces.PresenterInterface;
import com.edu.uptc.interfaces.ViewMainInterface;
import com.edu.uptc.models.Game;
import com.edu.uptc.views.Splash;

public class Run {

    private ViewMainInterface view;
    private PresenterInterface presenter;
    private ModelInterface model;

    public void start() {
        makeMVP();
        view.run();
    }

    private void makeMVP() {
        view = new Splash();
        presenter = new Presenter();
        model = new Game(view.getHeight(),view.getWidth());

        model.setPresenter(presenter);
        presenter.setModel(model);
        presenter.setView(view);
        view.setPresenter(presenter);
    }

}
