package com.github.hanyaeger.cosmiccomets.entities.satillitebelt.satillite;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;

public class Satillite extends DynamicCompositeEntity implements Collided {

    public Satillite(Coordinate2D initialLocation) {
        super(initialLocation);
        setRotationSpeed(0);
    }

    @Override
    protected void setupEntities() {
        addEntity(new SolarPanel(new Coordinate2D(0, 0)));
        addEntity(new RocketBody(new Coordinate2D(0, 0)));
    }

    @Override
    public void onCollision(Collider collider) {
        //TODO: Implement Behaviour
    }
}
