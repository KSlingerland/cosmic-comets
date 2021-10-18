package com.github.hanyaeger.cosmiccomets;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.cosmiccomets.entities.text.ScoreText;
import com.github.hanyaeger.cosmiccomets.scenes.GameLevel;
import com.github.hanyaeger.cosmiccomets.scenes.GameOverScene;
import com.github.hanyaeger.cosmiccomets.scenes.TitleScene;

public class CosmicComets extends YaegerGame {
    private ScoreText scoreText;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Cosmic Comets");
        setSize(new Size(1600, 900));

        scoreText = new ScoreText(new Coordinate2D(0, 50));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameLevel(this, scoreText));
        addScene(2, new GameOverScene(this, scoreText));
    }
}
