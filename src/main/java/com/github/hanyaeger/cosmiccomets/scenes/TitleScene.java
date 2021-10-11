package com.github.hanyaeger.cosmiccomets.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.cosmiccomets.CosmicComets;
import com.github.hanyaeger.cosmiccomets.entities.buttons.QuitButton;
import com.github.hanyaeger.cosmiccomets.entities.buttons.StartButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class TitleScene extends StaticScene {

    private final CosmicComets cosmicComets;

    public TitleScene(CosmicComets cosmicComets) {
        this.cosmicComets = cosmicComets;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/space.mp3");
        setBackgroundImage("backgrounds/background1.jpg");
    }

    @Override
    public void setupEntities() {
        var cosmicCometsText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 4), "Cosmic Comets");
        cosmicCometsText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        cosmicCometsText.setFill(Color.WHITESMOKE);
        cosmicCometsText.setFont(Font.font("Bodoni MT", FontWeight.BOLD, 80));
        addEntity(cosmicCometsText);

        var playGameText = new StartButton(new Coordinate2D(getWidth() / 4, getHeight() / 2), cosmicComets);
        playGameText.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(playGameText);

        var quitGameText = new QuitButton(new Coordinate2D(getWidth() / 4, getHeight() / 2 + 40), cosmicComets);
        quitGameText.setAnchorPoint(AnchorPoint.TOP_RIGHT);
        addEntity(quitGameText);
    }
}
