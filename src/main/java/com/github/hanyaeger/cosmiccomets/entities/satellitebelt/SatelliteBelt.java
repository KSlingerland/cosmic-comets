package com.github.hanyaeger.cosmiccomets.entities.satellitebelt;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.cosmiccomets.CosmicComets;
import com.github.hanyaeger.cosmiccomets.entities.text.ScoreText;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class SatelliteBelt extends DynamicCompositeEntity implements KeyListener {
    private final CosmicComets cosmicComets;
    private final ScoreText scoreText;

    private Satellite satellite1;
    private Satellite satellite2;
    private Satellite satellite3;
    private Satellite satellite4;

    /**
     * @param initialLocation the given location where the SatelliteBelt gets placed
     * @param scoreText       the instance of the ScoreText which displays the score
     * @param cosmicComets    the instance of the game
     */
    public SatelliteBelt(Coordinate2D initialLocation, ScoreText scoreText, CosmicComets cosmicComets) {
        super(initialLocation);
        setRotationSpeed(0);

        this.scoreText = scoreText;
        this.cosmicComets = cosmicComets;
    }

    @Override
    protected void setupEntities() {
        // Down
        satellite1 = new Satellite(new Coordinate2D(0, 200), cosmicComets, scoreText);
        satellite1.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(satellite1);

        // Up
        satellite2 = new Satellite(new Coordinate2D(0, -200), cosmicComets, scoreText);
        satellite2.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(satellite2);

        // Right
        satellite3 = new Satellite(new Coordinate2D(200, 0), cosmicComets, scoreText);
        satellite3.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(satellite3);

        // Left
        satellite4 = new Satellite(new Coordinate2D(-200, 0), cosmicComets, scoreText);
        satellite4.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(satellite4);
    }

    /**
     * Do an action when a certain key gets pressed
     *
     * @param set the set of keys
     */
    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        float speed = 4f;
        boolean rotateBelt = false;

        // TODO: fix: when moving up or down the rotation is reversed
        if (set.contains(KeyCode.RIGHT)) {
            // Move the SatelliteBelt to the right
            setRotationSpeed(-1.5);
            rotateBelt = true;
        }

        if (set.contains(KeyCode.LEFT)) {
            // Move the SatelliteBelt to the left
            setRotationSpeed(1.5);
            rotateBelt = true;
        }

        if (set.contains(KeyCode.UP)) {
            // Move the SatelliteBelt upwards
            satellite1.setMotion(speed, Direction.DOWN);
            satellite2.setMotion(speed, Direction.UP);
            satellite3.setMotion(speed, Direction.RIGHT);
            satellite4.setMotion(speed, Direction.LEFT);
        }

        if (set.contains(KeyCode.DOWN)) {
            // Move the SatelliteBelt downwards
            // check if the sattelites are moving into the middle of the screen with atleast 150 pixels of distance
            satellite1.setKeypressDirection(Direction.UP, speed);
            satellite2.setKeypressDirection(Direction.DOWN, speed);
            satellite3.setKeypressDirection(Direction.LEFT, speed);
            satellite4.setKeypressDirection(Direction.RIGHT, speed);
        }

        if (set.isEmpty()) {
            satellite1.setMotion(0, satellite1.getDirection());
            satellite2.setMotion(0, satellite2.getDirection());
            satellite3.setMotion(0, satellite3.getDirection());
            satellite4.setMotion(0, satellite4.getDirection());

            // fix als je de rotatie van UP EN DOWN doet dat hij de belt niet omdraait
            setRotationSpeedForSatellites(1);
        }
    }

    private void setRotationSpeedForSatellites(final float speed) {
        if (getRotationSpeed() > 0) {
            setRotationSpeed(getRotationSpeed() - speed);
        } else {
            setRotationSpeed(getRotationSpeed() + speed);
        }
    }
}
