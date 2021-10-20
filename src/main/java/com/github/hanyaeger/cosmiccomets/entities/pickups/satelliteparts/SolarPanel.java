package com.github.hanyaeger.cosmiccomets.entities.pickups.satelliteparts;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.cosmiccomets.entities.pickups.Pickup;

public class SolarPanel extends Pickup implements SatellitePart {

    /**
     * @param initialLocation the given location where the SolarPanel gets placed
     */
    public SolarPanel(Coordinate2D initialLocation) {
        super("sprites/solarpanel.png", initialLocation);
    }

    @Override
    public void setPart() {
        System.out.println("I Added an SolarPanel");
    }

    @Override
    public void consumePickup(){
        setPart();
        remove();
    }
}
