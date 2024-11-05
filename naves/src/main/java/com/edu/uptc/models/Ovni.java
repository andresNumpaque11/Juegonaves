package com.edu.uptc.models;

import java.util.Random;

public class Ovni extends Thread {

    private Random random;
    private int x, y;
    private int speed;
    private int angle;

    public Ovni() {
        random = new Random();
        this.angle = random.nextInt(360);
    }

  

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
