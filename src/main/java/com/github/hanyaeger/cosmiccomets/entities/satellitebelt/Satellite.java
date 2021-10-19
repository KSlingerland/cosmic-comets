package com.github.hanyaeger.cosmiccomets.entities.satellitebelt;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.cosmiccomets.entities.Asteroid;
import com.github.hanyaeger.cosmiccomets.entities.text.ScoreText;

public class Satellite extends DynamicSpriteEntity implements Collided, Collider {

    private final ScoreText scoreText;

    private int health = 2;
    private final int row = 0;

    public Satellite(Coordinate2D initialLocation, ScoreText scoreText) {
        super("sprites/satellite.png", initialLocation, new Size(64), 2, 2);
        setAutoCycle(200, row);
        setRotationSpeed(0);

        this.scoreText = scoreText;
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Asteroid) {
            health--;

            switch (health) {
                case 1 -> setAutoCycleRow(1);
                case 0 -> setOpacity(0);
            }

            scoreText.setScoreText(scoreText.getScore() + 1);
        }
    }
}
