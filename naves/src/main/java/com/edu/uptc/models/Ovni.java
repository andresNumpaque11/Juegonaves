package com.edu.uptc.models;

import java.util.ArrayList;
import java.util.Random;

public class Ovni extends Thread {

    private Coordinates coordinates;
    private int speed;
    private double angle;
    private ArrayList<Coordinates> trajectory;
    private int trajectoryIndex;

    public Ovni(int maxheight, int maxwidth, int speed) {
        new Random();
        int x = new Random().nextInt(maxwidth);
        int y = new Random().nextInt(maxheight);
        coordinates = new Coordinates(x, y);
        this.angle = new Random().nextInt(360);
        this.speed = speed;
        this.trajectory = new ArrayList<>();
        this.trajectoryIndex = 0;

    }

    @Override
    public void run() {
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        this.angle = angle;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public void setTrajectory(ArrayList<Coordinates> trajectory) {
        this.trajectory = trajectory;
        this.trajectoryIndex = 0;
    }

    public boolean hasTrajectory() {
        return trajectory != null && !trajectory.isEmpty() && trajectoryIndex < trajectory.size();
    }

    public void followTrajectory() {
        if (hasTrajectory()) {
            Coordinates nextCoordinate = trajectory.get(trajectoryIndex);
            coordinates.setX(nextCoordinate.getX());
            coordinates.setY(nextCoordinate.getY());
            trajectoryIndex++;
        }
    }

}
