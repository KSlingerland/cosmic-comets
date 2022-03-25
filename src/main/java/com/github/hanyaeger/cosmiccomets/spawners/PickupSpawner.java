package com.github.hanyaeger.cosmiccomets.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.cosmiccomets.entities.pickups.satelliteparts.RocketBody;
import com.github.hanyaeger.cosmiccomets.entities.pickups.satelliteparts.SolarPanel;

import java.util.Random;

public class PickupSpawner extends EntitySpawner {

    /**
     * PickupSpawner constructor which gives back the interval in milliseconds to EntitySpawner
     */
    public PickupSpawner() {
        super(5000);
    }

    @Override
    protected void spawnEntities() {
        if (new Random().nextInt(10) < 5) {
            spawn(new RocketBody(randomLocation()));
        } else {
            spawn(new SolarPanel(randomLocation()));
        }
    }

    /**
     * Returns a new instance of Coordinate2D
     * @return Coordinate2D
     */
    private Coordinate2D randomLocation() {
        // Give a random x coordinate between 400 and 1200
        double x = new Random().nextInt(1200) + 400;
        // Give a random y coordinate between 200 and 600
        double y = new Random().nextInt(600) + 200;
        return new Coordinate2D(x, y);
    }
}
