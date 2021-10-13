package com.github.hanyaeger.cosmiccomets.entities.satelliteparts.rocketbody;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class RocketBody extends RectangleEntity{

    public RocketBody(Coordinate2D initialLocation) {
        super(initialLocation);
        setWidth(20);
        setHeight(30);
        setFill(Color.DEEPPINK);

        setAnchorPoint(AnchorPoint.CENTER_CENTER);

    }
}
