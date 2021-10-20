package com.github.hanyaeger.cosmiccomets.entities.satellitebelt;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.cosmiccomets.CosmicComets;
import com.github.hanyaeger.cosmiccomets.entities.text.ScoreText;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class SatelliteBelt extends DynamicCompositeEntity implements KeyListener {
    private CosmicComets cosmicComets;
    private ScoreText scoreText;

    //TODO: Refactor
    private Satellite satellite1;
    private Satellite satellite2;
    private Satellite satellite3;
    private Satellite satellite4;

    public SatelliteBelt(Coordinate2D initialLocation, ScoreText scoreText, CosmicComets cosmicComets) {
        super(initialLocation);
        setRotationSpeed(0);

        this.scoreText = scoreText;
        this.cosmicComets = cosmicComets;
    }

    @Override
    protected void setupEntities() {
        //TODO: Implement Individual Satellite Rotations
        satellite1 = new Satellite(new Coordinate2D(0, 200), cosmicComets, scoreText);
        satellite1.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(satellite1);

        satellite2 = new Satellite(new Coordinate2D(0, -200), cosmicComets, scoreText);
        satellite2.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(satellite2);

        satellite3 = new Satellite(new Coordinate2D(200, 0), cosmicComets, scoreText);
        satellite3.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(satellite3);

        satellite4 = new Satellite(new Coordinate2D(-200, 0), cosmicComets, scoreText);
        satellite4.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(satellite4);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        if (set.contains(KeyCode.RIGHT)) {
            setRotationSpeed(-1.5);
        } else if (set.contains(KeyCode.LEFT)) {
            setRotationSpeed(1.5);
        } else if (set.contains(KeyCode.UP)) {
            //TODO: Implement Up Movement
        } else if (set.contains(KeyCode.DOWN)) {
            //TODO: Implement Down Movement
        } else if (set.isEmpty()) {
            if (getRotationSpeed() > 0) {
                setRotationSpeed(getRotationSpeed() - 1);
            } else {
                setRotationSpeed(getRotationSpeed() + 1);
            }
        }
    }
}
