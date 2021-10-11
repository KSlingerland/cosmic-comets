package com.github.hanyaeger.cosmiccomets.entities.satillitebelt.satillite;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class SolarPanel extends RectangleEntity {
    public SolarPanel(Coordinate2D initialLocation) {
        super(initialLocation);
        setWidth(40);
        setHeight(10);
        setFill(Color.DARKBLUE);

        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
