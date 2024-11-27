package com.edu.uptc.views;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelInfoGame extends JPanel {

    private JLabel title, clients, listClients, moveOvnis, crashedOvnis, numMoveOvnis, numCreshedOvnis;

    public PanelInfoGame() {
        this.setBackground(Color.decode("#000000"));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        initComponents();
    }

    private void initComponents() {
        title = new JLabel("Juego Naves");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setForeground(Color.WHITE);
        add(title);

        clients = new JLabel("Clientes conectados: ");
        clients.setForeground(Color.WHITE);
        add(clients);

        listClients = new JLabel();
        listClients.setForeground(Color.WHITE);
        add(listClients);

        moveOvnis = new JLabel("Ovnis en movimiento: ");
        moveOvnis.setForeground(Color.WHITE);
        add(moveOvnis);

        numMoveOvnis = new JLabel();
        numMoveOvnis.setForeground(Color.WHITE);
        add(numMoveOvnis);

        crashedOvnis = new JLabel("Ovnis estrellados: ");
        crashedOvnis.setForeground(Color.WHITE);
        add(crashedOvnis);

        numCreshedOvnis = new JLabel();
        numCreshedOvnis.setForeground(Color.WHITE);
        add(numCreshedOvnis);
    }

    public void setNumCreshedOvnis(String numCreshedOvnis) {
        this.numCreshedOvnis.setText(numCreshedOvnis);
    }

    public void setNumMoveOvnis(String numMoveOvnis) {
        this.numMoveOvnis.setText(numMoveOvnis);
    }
}
