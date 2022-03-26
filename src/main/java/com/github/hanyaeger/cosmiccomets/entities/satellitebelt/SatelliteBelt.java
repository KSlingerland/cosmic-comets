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

    private KeyCode lastKeyInput = null;

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

        if (set.contains(KeyCode.RIGHT)) {
            // Move the SatelliteBelt to the right
            setRotationSpeed(-1.5);
            lastKeyInput = KeyCode.RIGHT;
        } else if (set.contains(KeyCode.LEFT)) {
            // Move the SatelliteBelt to the left
            setRotationSpeed(1.5);
            lastKeyInput = KeyCode.LEFT;
        } else if (set.contains(KeyCode.UP)) {
            // Move the SatelliteBelt upwards
            satellite1.setMotion(speed, Direction.DOWN);
            satellite2.setMotion(speed, Direction.UP);
            satellite3.setMotion(speed, Direction.RIGHT);
            satellite4.setMotion(speed, Direction.LEFT);
            lastKeyInput = KeyCode.UP;
        } else if (set.contains(KeyCode.DOWN)) {
            // Move the SatelliteBelt downwards
            // check if the satellites are moving into the middle of the screen with atleast 150 pixels of distance
            satellite1.setKeypressDirection(speed, Direction.UP);
            satellite2.setKeypressDirection(speed, Direction.DOWN);
            satellite3.setKeypressDirection(speed, Direction.LEFT);
            satellite4.setKeypressDirection(speed, Direction.RIGHT);
            lastKeyInput = KeyCode.DOWN;
        } else if (set.isEmpty()) {
            // Stop the satellites from moving directions
            satellite1.stopMovingDirection();
            satellite2.stopMovingDirection();
            satellite3.stopMovingDirection();
            satellite4.stopMovingDirection();

            // Check if the last key input was RIGHT or LEFT and then lower the speed of the SatelliteBelt
            // This must not happen when moving the SatelliteBelt up or down
            if (lastKeyInput == KeyCode.RIGHT || lastKeyInput == KeyCode.LEFT) {
                if (getRotationSpeed() > 0) {
                    setRotationSpeed(getRotationSpeed() - 1);
                } else {
                    setRotationSpeed(getRotationSpeed() + 1);
                }
            }

            // Reset the last key input
            lastKeyInput = null;
        }
    }
}
