package com.github.hanyaeger.cosmiccomets.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class ScoreText extends TextEntity {
    private int score = 0;

    public ScoreText(Coordinate2D initialLocation) {
        super(initialLocation, "Score: 0");

        setFont(Font.font("", FontWeight.NORMAL, 32));
        setFill(Color.WHITE);
    }

    public void setScoreText(int score) {
        this.score = score; //save new total score in this instance of ScoreText
        setText("Score: " + score);
    }

    public int getScore() {
        return score;
    }
}
