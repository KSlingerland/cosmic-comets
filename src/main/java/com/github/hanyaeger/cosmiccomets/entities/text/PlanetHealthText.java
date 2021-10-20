package com.github.hanyaeger.cosmiccomets.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class PlanetHealthText extends TextEntity {

    /**
     * @param initialLocation the location where the PlanetHealthText gets placed
     */
    public PlanetHealthText(Coordinate2D initialLocation) {
        super(initialLocation);

        setFont(Font.font("", FontWeight.NORMAL, 32));
        setFill(Color.WHITE);
    }

    /**
     * Set the new health of the planet
     * @param health the given health to set
     */
    public void setHealthText(final int health) {
        setText("Planet Health: " + health);
    }
}
