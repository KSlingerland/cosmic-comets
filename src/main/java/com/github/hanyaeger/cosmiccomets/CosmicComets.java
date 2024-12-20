package com.github.hanyaeger.cosmiccomets;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import com.github.hanyaeger.cosmiccomets.scenes.GameLevel;
import com.github.hanyaeger.cosmiccomets.scenes.GameOverScene;
import com.github.hanyaeger.cosmiccomets.scenes.TitleScene;

public class CosmicComets extends YaegerGame {

    private int score;

    /**
     * The main method launching the game
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void setupGame() {
        setGameTitle("Cosmic Comets");
        setSize(new Size(1600, 900));
    }

    @Override
    public void setupScenes() {
        addScene(0, new TitleScene(this));
        addScene(1, new GameLevel(this));
        addScene(2, new GameOverScene(this));
    }

    /**
     * Returns the score of the total destroyed asteroids
     * @return score
     */
    public int getScore() {
        return score;
    }

    /**
     * Set the new score of the total destroyed asteroids
     * @param score the score to be changed
     */
    public void setScore(int score) {
        this.score = score;
    }
}
