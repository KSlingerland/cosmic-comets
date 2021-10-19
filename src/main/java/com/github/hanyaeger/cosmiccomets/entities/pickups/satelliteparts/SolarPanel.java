package com.github.hanyaeger.cosmiccomets.entities.pickups.satelliteparts;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.cosmiccomets.entities.pickups.Pickup;

public class SolarPanel extends Pickup {

    public SolarPanel(Coordinate2D initialLocation) {
        super("sprites/solarpanel.png", initialLocation);
    }
}
