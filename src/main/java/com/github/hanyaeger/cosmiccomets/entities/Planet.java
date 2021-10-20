package com.github.hanyaeger.cosmiccomets.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.cosmiccomets.CosmicComets;
import com.github.hanyaeger.cosmiccomets.entities.text.PlanetHealthText;


public class Planet extends DynamicSpriteEntity implements Collided, Collider {
    private final PlanetHealthText planetHealthText;
    private final CosmicComets cosmicComets;
    private int health = 3;

    /**
     * @param initialLocation the given location where the Planet gets placed
     * @param planetHealthText the instance of PlanetHealthText
     * @param cosmicComets the instance of the game
     */
    public Planet(Coordinate2D initialLocation, PlanetHealthText planetHealthText, final CosmicComets cosmicComets) {
        super("sprites/Earth.png", initialLocation, new Size(128), 16, 16);
        setAutoCycle(1);

        this.planetHealthText = planetHealthText;
        this.cosmicComets = cosmicComets;

        this.planetHealthText.setHealthText(health);
    }

    @Override
    public void onCollision(Collider collider) {
        //TODO: Implement Behaviour
        if (collider instanceof Asteroid) {
            health--;
            planetHealthText.setHealthText(health);

            if (health <= 0) {
                cosmicComets.setActiveScene(2);
            }
        }
    }
}
