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
    private final CosmicComets cosmicComets;
    private final ScoreText scoreText;

    private int health = 2;

    /**
     * @param initialLocation the location where the satellite gets placed
     * @param cosmicComets the instance of the game
     * @param scoreText the instance of the ScoreText which displays the score
     */
    public Satellite(final Coordinate2D initialLocation, final CosmicComets cosmicComets, final ScoreText scoreText) {
        super("sprites/satellite.png", initialLocation, new Size(64), 2, 2);
        setAutoCycle(200, 0);
        setRotationSpeed(0);

        this.cosmicComets = cosmicComets;
        this.scoreText = scoreText;
    }

    @Override
    public void onCollision(Collider collider) {
        int score = cosmicComets.getScore();
        if (collider instanceof Asteroid) {
            health--;

            switch (health) {
                case 1 -> {
                    setAutoCycleRow(1);
                }
                case 0 -> {
                    setOpacity(0);
                    // Remove the asteroid when the health of the satellite is 0, when health is 0 set the opacity to 0,
                    // but in the class Asteroid it removes the asteroid when it collides with the satellite if the opacity is NOT 0
                    // so the asteroid does not get removed even if it destroys the satellite
                    ((Asteroid) collider).remove();
                }
            }

            cosmicComets.setScore(++score);
            scoreText.setScoreText(score);
        } else if (collider instanceof Pickup) {
            ((Pickup) collider).consumePickup();
        }
    }
}
