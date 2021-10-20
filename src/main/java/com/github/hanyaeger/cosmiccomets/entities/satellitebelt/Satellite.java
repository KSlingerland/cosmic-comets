package com.github.hanyaeger.cosmiccomets.entities.satellitebelt;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.cosmiccomets.CosmicComets;
import com.github.hanyaeger.cosmiccomets.entities.Asteroid;
import com.github.hanyaeger.cosmiccomets.entities.pickups.Pickup;
import com.github.hanyaeger.cosmiccomets.entities.text.ScoreText;

public class Satellite extends DynamicSpriteEntity implements Collided, Collider {
    private CosmicComets cosmicComets;
    private ScoreText scoreText;

    private int health = 2;
    private int score = 0;

    public Satellite(final Coordinate2D initialLocation, final CosmicComets cosmicComets, final ScoreText scoreText) {
        super("sprites/satellite.png", initialLocation, new Size(64), 2, 2);
        setAutoCycle(200,0);
        setRotationSpeed(0);

        this.cosmicComets = cosmicComets;
        this.scoreText = scoreText;
    }

    @Override
    public void onCollision(Collider collider) {
        score = cosmicComets.getScore();
        if (collider instanceof Asteroid) {
            health--;

            switch (health) {
                case 1 -> setAutoCycleRow(1);
                case 0 -> setOpacity(0);
            }

            cosmicComets.setScore(++score);
            scoreText.setScoreText(score);
        } else if (collider instanceof Pickup) {
            ((Pickup) collider).consumePickup();
        }
    }
}
