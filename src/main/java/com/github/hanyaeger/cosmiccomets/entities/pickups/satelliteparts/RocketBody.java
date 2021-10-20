package com.github.hanyaeger.cosmiccomets.entities.pickups.satelliteparts;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.cosmiccomets.entities.pickups.Pickup;

public class RocketBody extends Pickup implements SatellitePart {

    public RocketBody(Coordinate2D initialLocation) {
        super("sprites/rocketbody.png", initialLocation);
    }

    @Override
    public void setPart() {
        System.out.println("I Added an RocketBody");
    }

    @Override
    public void consumePickup(){
        setPart();
        remove();
    }
}
