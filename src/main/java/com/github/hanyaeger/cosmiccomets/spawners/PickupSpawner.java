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

    //TODO: Implement Correct Spawning Locations

    /**
     * Returns a new instance of Coordinate2D
     * @return Coordinate2D
     */
    private Coordinate2D randomLocation() {
        double x = new Random().nextInt(800);
        return new Coordinate2D(x, 450);
    }
}
