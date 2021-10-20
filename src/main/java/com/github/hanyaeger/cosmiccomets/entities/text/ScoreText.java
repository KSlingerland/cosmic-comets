package com.github.hanyaeger.cosmiccomets.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScoreText extends TextEntity {

    /**
     * @param initialLocation the given location where the ScoreText gets placed
     */
    public ScoreText(Coordinate2D initialLocation) {
        super(initialLocation, "Score: 0");
        setFont(Font.font("", FontWeight.NORMAL, 32));
        setFill(Color.WHITE);
    }

    /**
     * Set the new score of the total destroyed asteroids
     * @param score the given score to set
     */
    public void setScoreText(final int score) {
        setText("Score: " + score);
    }
}
