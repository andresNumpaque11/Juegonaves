package com.edu.uptc.presenters;

import java.awt.Dimension;
import java.awt.Toolkit;

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
        Toolkit t = Toolkit.getDefaultToolkit();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        view = new Splash((int) screenSize.getWidth(),(int)screenSize.getHeight());
        presenter = new Presenter();
        model = new Game(view.getPanelHeight(), view.getPanelWidth()-(view.getPanelWidth()/4));

        model.setPresenter(presenter);
        presenter.setModel(model);
        presenter.setView(view);
        view.setPresenter(presenter);
    }

}
