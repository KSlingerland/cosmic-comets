package com.github.hanyaeger.cosmiccomets.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.cosmiccomets.CosmicComets;
import com.github.hanyaeger.cosmiccomets.entities.planet.Planet;
import com.github.hanyaeger.cosmiccomets.entities.satillitebelt.SatelliteBelt;
import com.github.hanyaeger.cosmiccomets.spawners.AsteroidSpawner;

public class GameLevel extends DynamicScene implements EntitySpawnerContainer {

    private final CosmicComets cosmicComets;

    public GameLevel(CosmicComets cosmicComets) {

        this.cosmicComets = cosmicComets;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {
        addEntity(new Planet(new Coordinate2D(getWidth() / 2 - 64, getHeight() / 2 - 64)));
        addEntity(new SatelliteBelt(new Coordinate2D(getWidth() / 2, getHeight() / 2)));
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new AsteroidSpawner(getWidth(), getHeight()));
    }
}
