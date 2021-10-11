package com.github.hanyaeger.cosmiccomets.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.StaticScene;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class GameOverScene extends StaticScene {
    @Override
    public void setupScene() {

    }

    @Override
    public void setupEntities() {
        var missionFailedText = new TextEntity(new Coordinate2D(getWidth() / 2, getHeight() / 3));
        missionFailedText.setAnchorPoint(AnchorPoint.BOTTOM_CENTER);
        missionFailedText.setFont(Font.font("", 32));
        missionFailedText.setFill(Color.RED);
        addEntity(missionFailedText);
    }
}
