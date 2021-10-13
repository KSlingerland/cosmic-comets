package com.github.hanyaeger.cosmiccomets.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.cosmiccomets.CosmicComets;
import com.github.hanyaeger.cosmiccomets.entities.Asteroid;

import java.util.Random;

public class AsteroidSpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;
    private CosmicComets cosmicComets;

    public AsteroidSpawner(double sceneWidth, double sceneHeight) {
        super(1000); //TODO: Implement Random Spawning Rate
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {
        spawn(new Asteroid(randomLocation(), 2));
    }

    private Coordinate2D randomLocation() {
        //TODO: Implement Spawning only from Edge
        double y = new Random().nextInt((int) sceneHeight);
        double x = new Random().nextInt((int) sceneWidth);

        return new Coordinate2D(x, y);
    }
}
