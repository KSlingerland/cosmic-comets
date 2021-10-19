package com.github.hanyaeger.cosmiccomets.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.cosmiccomets.CosmicComets;
import com.github.hanyaeger.cosmiccomets.entities.buttons.QuitButton;
import com.github.hanyaeger.cosmiccomets.entities.buttons.RetryButton;
import com.github.hanyaeger.cosmiccomets.entities.text.ScoreText;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameOverScene extends StaticScene {

    private final CosmicComets cosmicComets;
    private final ScoreText scoreText;

    public GameOverScene(CosmicComets cosmicComets, ScoreText scoreText) {
        this.cosmicComets = cosmicComets;
        this.scoreText = scoreText;
    }

    @Override
    public void setupScene() {
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {
        var missionFailedText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 3), "Game Over");
        missionFailedText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        missionFailedText.setFont(Font.font("", 40));
        missionFailedText.setFill(Color.RED);
        addEntity(missionFailedText);

        var scoreText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 3 + 40), "Asteroids destroyed: " + this.scoreText.getScore());
        scoreText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        scoreText.setFont(Font.font("", 32));
        scoreText.setFill(Color.GREY);
        addEntity(scoreText);

        var retryButton = new RetryButton(new Coordinate2D(getWidth() / 2, getHeight() / 2), cosmicComets);
        retryButton.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        addEntity(retryButton);

        var quitButton = new QuitButton(new Coordinate2D(getWidth() / 2, getHeight() / 2 + 40), cosmicComets);
        quitButton.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        addEntity(quitButton);
    }
}
