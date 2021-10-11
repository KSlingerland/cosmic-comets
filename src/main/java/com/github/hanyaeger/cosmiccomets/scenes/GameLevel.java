package com.github.hanyaeger.cosmiccomets.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.cosmiccomets.CosmicComets;
import com.github.hanyaeger.cosmiccomets.entities.Planet;

public class GameLevel extends DynamicScene {

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
        addEntity(new Planet(new Coordinate2D(getWidth() / 2 - 64, getHeight() / 2 - 64), cosmicComets));
    }
}
