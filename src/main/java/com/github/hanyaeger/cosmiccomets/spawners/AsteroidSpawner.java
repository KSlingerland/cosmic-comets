package com.github.hanyaeger.cosmiccomets.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.cosmiccomets.CosmicComets;
import com.github.hanyaeger.cosmiccomets.entities.Asteroid;
import com.github.hanyaeger.cosmiccomets.entities.text.ScoreText;

import java.util.Random;

public class AsteroidSpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;
    private CosmicComets cosmicComets;

    public AsteroidSpawner(double sceneWidth, double sceneHeight) {
        super(2000); //TODO: Implement Random Spawning Rate
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {
        spawn(new Asteroid(randomLocation(), 2));
    }

    private Coordinate2D randomLocation() {
        int location = new Random().nextInt(4);

        // TODO: change this?
        // Standard coordinates for left side
        double x = 0;
        double y = new Random().nextInt((int) sceneHeight);

        switch (location) {
            case 1 -> {  // Top side
                x = new Random().nextInt((int) sceneWidth);
                y = 0;
            }
            case 2 -> {  // Right side
                x = new Random().nextInt((int) sceneWidth);
                y = sceneHeight;
            }
            case 3 -> {  // Bottom side
                x = sceneWidth;
                y = new Random().nextInt((int) sceneHeight);
            }
        }

        return new Coordinate2D(x, y);
    }
}
