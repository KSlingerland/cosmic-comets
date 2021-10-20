package com.github.hanyaeger.cosmiccomets.entities.pickups.powerups;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.cosmiccomets.entities.pickups.Pickup;

public class Booster extends Pickup implements PowerUp {

    public Booster(String resource, Coordinate2D initialLocation) {
        super(resource, initialLocation);
    }

    @Override
    public void addPowerUp() {

    }

    @Override
    public void consumePickup(){

    }
}
