package com.github.hanyaeger.cosmiccomets.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.cosmiccomets.CosmicComets;
import com.github.hanyaeger.cosmiccomets.entities.planet.Planet;
import com.github.hanyaeger.cosmiccomets.entities.satellitebelt.SatelliteBelt;
import com.github.hanyaeger.cosmiccomets.entities.text.PlanetHealthText;
import com.github.hanyaeger.cosmiccomets.entities.text.ScoreText;
import com.github.hanyaeger.cosmiccomets.spawners.AsteroidSpawner;
import com.github.hanyaeger.cosmiccomets.spawners.PickupSpawner;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {
    private final CosmicComets cosmicComets;
    private final ScoreText scoreText;

    public GameLevel(CosmicComets cosmicComets, ScoreText scoreText) {
        this.cosmicComets = cosmicComets;
        this.scoreText = scoreText;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {
        PlanetHealthText planetHealthText = new PlanetHealthText(new Coordinate2D(0, 0));
        addEntity(planetHealthText);

        addEntity(new Planet(new Coordinate2D(getWidth() / 2 - 64, getHeight() / 2 - 64), planetHealthText, cosmicComets));
        addEntity(new SatelliteBelt(new Coordinate2D(getWidth() / 2, getHeight() / 2), scoreText));
        addEntity(scoreText);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new AsteroidSpawner(getWidth(), getHeight()));
        addEntitySpawner(new PickupSpawner());
    }
}
