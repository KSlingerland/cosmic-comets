package com.github.hanyaeger.cosmiccomets.entities.planet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;

public class PlanetSprite extends DynamicSpriteEntity {
    /**
     * @param initialLocation the location of where the PlanetSprite gets placed
     */
    public PlanetSprite(Coordinate2D initialLocation) {
        super("sprites/Earth.png", initialLocation, new Size(128), 16, 16);
        setAutoCycle(1);
    }
}
