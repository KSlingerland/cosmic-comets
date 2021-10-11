package com.github.hanyaeger.cosmiccomets.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;

import java.util.Random;

public class AsteroidSpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;

    public AsteroidSpawner(double sceneWidth, double sceneHeight) {
        super(100); //TODO: Implement Random Spawning Rate
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {
        //TODO: Implement Spawning
    }

    private Coordinate2D randomLocation() {
        double y = new Random().nextInt((int) sceneHeight);
        double x = new Random().nextInt((int) sceneWidth);

        return new Coordinate2D(x, y);
    }
}
