package com.edu.uptc.views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTittle extends JPanel {

    private JLabel tittle;

    public PanelTittle() {
        tittle = new JLabel("Ovnis al escape");
        add(tittle);
        this.setVisible(true);
        this.setBackground(Color.decode("#4e0196"));
    }

    public void configText(JLabel lbl) {
        lbl.setForeground(Color.WHITE);
        lbl.setFont(new Font("Arial", Font.ITALIC, 30));
        this.add(lbl);
    }

}
