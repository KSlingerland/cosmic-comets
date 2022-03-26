package com.github.hanyaeger.cosmiccomets.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import com.github.hanyaeger.cosmiccomets.entities.Asteroid;

import java.util.Random;

public class AsteroidSpawner extends EntitySpawner {

    private final double sceneWidth;
    private final double sceneHeight;

    /**
     * Set the sceneWidth and sceneHeight for this Object
     * @param sceneWidth get the scene width of the given window
     * @param sceneHeight get the scene height of the given window
     */
    public AsteroidSpawner(double sceneWidth, double sceneHeight) {
        super(5000); //TODO: Implement Random Spawning Rate
        this.sceneWidth = sceneWidth;
        this.sceneHeight = sceneHeight;
    }

    @Override
    protected void spawnEntities() {
        spawn(new Asteroid(randomLocation(), getRandomNumberInRange(5, 2)));
    }

    /**
     * Returns a random location given to an asteroid to for the spawning position
     * @return Coordinate2D
     */
    private Coordinate2D randomLocation() {
        int location = new Random().nextInt(4);

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

    /**
     * Generates a random number between the given minimum and maximum integers
     * @param max the given maximum
     * @param min the given minimum
     * @return random integer
     */
    private int getRandomNumberInRange(final int max, final int min) {
        return new Random().nextInt(max - min + 1) + min;
    }
}
