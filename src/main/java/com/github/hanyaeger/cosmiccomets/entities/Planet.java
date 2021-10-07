package com.github.hanyaeger.cosmiccomets.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.cosmiccomets.CosmicComets;

public class Planet extends DynamicSpriteEntity implements Collided {
    private CosmicComets cosmicComets;

    public Planet(final Coordinate2D initialLocation, CosmicComets cosmicComets) {
        super("sprites/Earth.png", initialLocation, new Size(128,128), 16,16);
        setAutoCycle(1);

        this.cosmicComets = cosmicComets;
    }

    @Override
    public void onCollision(Collider collider) {

    }
}
