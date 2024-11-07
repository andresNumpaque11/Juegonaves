package com.edu.uptc.presenters;

import com.edu.uptc.interfaces.ModelInterface;
import com.edu.uptc.interfaces.PresenterInterface;
import com.edu.uptc.interfaces.ViewInterface;
import com.edu.uptc.models.Game;
import com.edu.uptc.views.Splash;

public class Run {

    private ViewInterface view;
    private PresenterInterface presenter;
    private ModelInterface model;

    public void start() {
        makeMVP();
        view.run();
        presenter.start();

    }

    private void makeMVP() {
        view = new Splash();
        presenter = new Presenter();
        model = new Game();

        view.setPresenter(presenter);
        model.setPresenter(presenter);
        presenter.setModel(model);
        presenter.setView(view);
    }

}
