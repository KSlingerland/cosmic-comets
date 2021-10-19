package com.github.hanyaeger.cosmiccomets.entities.pickups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.cosmiccomets.entities.Asteroid;
import com.github.hanyaeger.cosmiccomets.entities.planet.Planet;
import com.github.hanyaeger.cosmiccomets.entities.satellitebelt.Satellite;

public abstract class Pickup extends DynamicSpriteEntity implements Collided, Collider {

    public Pickup(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation, new Size(64));
        setRotationSpeed(2);
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Satellite) {
        } else if (collider instanceof Asteroid) {
            remove();
        } else if (collider instanceof Planet) {
            remove();
        }
    }
}
