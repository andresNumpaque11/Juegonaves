package com.edu.uptc.views;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class IinitialSettingsGame extends JFrame {

    private JLabel numOvnis, timeappeared, velocity, direction;
    private JTextField txtNumOvnis, txtTimeappeared, txtVelocity;
    private JButton startGame, cancel;
    private ViewGame viewGame;

    public IinitialSettingsGame() {
        super("Configuración de juego");
        initComponents();
        this.setSize(400, 300);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    private void initComponents() {
        numOvnis = new JLabel("N° de ovnis:");
        numOvnis.setBounds(20, 20, 150, 25);
        add(numOvnis);

        timeappeared = new JLabel("Tiempo de aparición (ms):");
        timeappeared.setBounds(20, 60, 150, 25);
        add(timeappeared);

        velocity = new JLabel("Velocidad de los ovnis:");
        velocity.setBounds(20, 100, 150, 25);
        add(velocity);

        txtNumOvnis = new JTextField();
        txtNumOvnis.setBounds(180, 20, 150, 25);
        add(txtNumOvnis);

        txtTimeappeared = new JTextField();
        txtTimeappeared.setBounds(180, 60, 150, 25);
        add(txtTimeappeared);

        txtVelocity = new JTextField();
        txtVelocity.setBounds(180, 100, 150, 25);
        add(txtVelocity);

        addButtons();
        viewGame = new ViewGame();
    }

    private void addButtons() {
        startGame = new JButton("Iniciar Juego");
        startGame.setBounds(50, 200, 120, 30);
        startGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // if (validateFields()) {
                // setVisible(false);
                // viewGame.setVisible(true);

                // }
                setVisible(false);
                viewGame.setVisible(true);
            }
        });

        cancel = new JButton("Cancelar");
        cancel.setBounds(200, 200, 120, 30);
        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        this.add(startGame);
        add(cancel);
    }

    // private boolean validateFields() {
    // if (txtNumOvnis.getText().isEmpty() || txtTimeappeared.getText().isEmpty() ||
    // txtVelocity.getText().isEmpty() || txtDirection.getText().isEmpty()) {
    // JOptionPane.showMessageDialog(this, "Todos los campos deben ser llenados.",
    // "Error",
    // JOptionPane.ERROR_MESSAGE);
    // return false;
    // }

    // try {
    // Integer.parseInt(txtNumOvnis.getText());
    // Integer.parseInt(txtTimeappeared.getText());
    // Integer.parseInt(txtVelocity.getText());
    // } catch (NumberFormatException e) {
    // JOptionPane.showMessageDialog(this,
    // "Los campos N° de ovnis, Tiempo de aparición y Velocidad deben ser
    // numéricos.", "Error",
    // JOptionPane.ERROR_MESSAGE);
    // return false;
    // }

    // return true;
    // }

    public JLabel getNumOvnis() {
        return numOvnis;
    }

    public JLabel getTimeappeared() {
        return timeappeared;
    }

    public JLabel getVelocity() {
        return velocity;
    }

    public JLabel getDirection() {
        return direction;
    }

    public JTextField getTxtNumOvnis() {
        return txtNumOvnis;
    }

    public JTextField getTxtTimeappeared() {
        return txtTimeappeared;
    }

    public JTextField getTxtVelocity() {
        return txtVelocity;
    }

    public ViewGame getViewGame() {
        return viewGame;
    }

}
