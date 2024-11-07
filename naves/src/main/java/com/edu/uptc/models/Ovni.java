package com.edu.uptc.models;

import java.util.Random;

public class Ovni extends Thread {

    private Random random;
    private Coordinates coordinates;
    private int speed;
    private int angle;

    public Ovni() {
        random = new Random();
        int x = random.nextInt(1280);
        int y = random.nextInt(720);
        coordinates = new Coordinates(x, y);
        this.angle = random.nextInt(360);
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("mover a la derecha xd");
            try {
                Thread.sleep(3000); // Pausa el hilo actual (ovni) durante 3 segundos
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Error en el hilo ovni");
            }
        }
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }
    public Coordinates getCoordinates() {
        return coordinates;
    }

}
