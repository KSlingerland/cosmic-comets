package com.github.hanyaeger.cosmiccomets.entities.planet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.cosmiccomets.CosmicComets;
import com.github.hanyaeger.cosmiccomets.entities.Asteroid;
import com.github.hanyaeger.cosmiccomets.entities.text.PlanetHealthText;


public class Planet extends DynamicCompositeEntity implements Collided, Collider {
    private final PlanetHealthText planetHealthText;
    private final CosmicComets cosmicComets;
    private int health = 3;

    public Planet(Coordinate2D initialLocation, PlanetHealthText planetHealthText, CosmicComets cosmicComets) {
        super(initialLocation);

        this.planetHealthText = planetHealthText;
        this.cosmicComets = cosmicComets;
    }

    @Override
    protected void setupEntities() {
        var planetSprite = new PlanetSprite(new Coordinate2D(0,0));
        addEntity(planetSprite);
        planetHealthText.setHealthText(health);
    }

    @Override
    public void onCollision(Collider collider) {
        //TODO: Implement Behaviour
        if (collider instanceof Asteroid) {
            health--;
            planetHealthText.setHealthText(health);

            if (health <= 0) {
                this.cosmicComets.setActiveScene(2);
            }
        }
    }
}
