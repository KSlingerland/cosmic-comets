package com.github.hanyaeger.cosmiccomets.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.cosmiccomets.entities.planet.Planet;
import com.github.hanyaeger.cosmiccomets.entities.satellitebelt.Satellite;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;

public class Asteroid extends DynamicCircleEntity implements Collided, Collider, SceneBorderCrossingWatcher {

    /**
     * @param initialLocation the location where the Asteroid gets placed
     * @param speed the given speed of how fast the asteroids moves
     */
    public Asteroid(Coordinate2D initialLocation, double speed) {
        super(initialLocation);
        setRadius(15);

        setFill(Color.ORANGE);
        setStrokeColor(Color.BROWN);

        setMotion(speed, getAngle(new Coordinate2D(800, 450), initialLocation));
    }

    /**
     * @param targetCoordinate the given target coordinates (example: the planet)
     * @param originCoordinate the given origin coordinates
     * @return Point2D angle to target coordinates
     */
    public double getAngle(Coordinate2D targetCoordinate, Coordinate2D originCoordinate) {
        if (originCoordinate.equals(targetCoordinate)) {
            return 0D;
        }

        final var delta = targetCoordinate.subtract(originCoordinate);
        final var normalizedDelta = delta.normalize();
        var angle = new Point2D(0, 1).angle(normalizedDelta);

        if (delta.getX() < 0) {
            angle = 360 - angle;
        }
        return angle;
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Planet) {
            remove();
        }

        //TODO: Implement Better Collision
        if (collider instanceof Satellite) {
            // Remove the Asteroid if it collides with
            if (((Satellite) collider).getOpacity() != 0) {
                remove();
            }
        }
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}

