package com.github.hanyaeger.cosmiccomets.entities.planet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;


public class Planet extends DynamicCompositeEntity implements Collided, Collider {

    public Planet(Coordinate2D initialLocation) {
        super(initialLocation);
    }

    @Override
    protected void setupEntities() {
        var planetSprite = new PlanetSprite(new Coordinate2D(0,0));
        addEntity(planetSprite);
    }

    @Override
    public void onCollision(Collider collider) {
        //TODO: Implement Behaviour
    }
}
