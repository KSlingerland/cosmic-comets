package com.github.hanyaeger.cosmiccomets.entities.satellitebelt.satellite;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.cosmiccomets.entities.Asteroid;
import com.github.hanyaeger.cosmiccomets.entities.satelliteparts.rocketbody.RocketBody;
import com.github.hanyaeger.cosmiccomets.entities.satelliteparts.solarpanel.SolarPanel;
import com.github.hanyaeger.cosmiccomets.entities.text.ScoreText;

public class Satellite extends DynamicCompositeEntity implements Collided ,Collider {
    private final ScoreText scoreText;

    public Satellite(Coordinate2D initialLocation, ScoreText scoreText) {
        super(initialLocation);
        setRotationSpeed(0);
        this.scoreText = scoreText;
        this.scoreText.setScoreText(this.scoreText.getScore());
    }

    @Override
    protected void setupEntities() {
        addEntity(new SolarPanel(new Coordinate2D(0, 0)));
        addEntity(new RocketBody(new Coordinate2D(0, 0)));
    }

    @Override
    public void onCollision(Collider collider) {
        if (collider instanceof Asteroid) {
            //TODO: Implement Behavior On Collision
            int newScore = this.scoreText.getScore() + 1;
            this.scoreText.setScoreText(newScore);
        }
    }
}
