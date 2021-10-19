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
        super(2000); //TODO: Implement Random Spawning Rate
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {
        spawn(new Asteroid(randomLocation(), getRandomNumberInRange(5, 2)));
    }

    //TODO: Add JavaDOC

    /**
     * @return
     */
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

    //TODO: Add JavaDOC

    /**
     * @param max
     * @param min
     * @return
     */
    private int getRandomNumberInRange(int max, int min) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
