package com.github.hanyaeger.cosmiccomets.entities;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.YaegerEntity;
import com.github.hanyaeger.api.entities.impl.DynamicCircleEntity;
import com.github.hanyaeger.cosmiccomets.entities.satillitebelt.satillite.Satillite;
import javafx.scene.paint.Color;

public class Astroid extends DynamicCircleEntity implements Collided, Collider {

    public Astroid(Coordinate2D initialLocation, double speed) {
        super(initialLocation);

        setFill(Color.ORANGE);
        setStrokeColor(Color.BROWN);

        setRadius(15);
        setMotion(speed, angleToTaget());
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Satillite) {

        }
    }

    public double angleToTaget(){
        return angleTo(new Coordinate2D(800, 450));
    }
}
