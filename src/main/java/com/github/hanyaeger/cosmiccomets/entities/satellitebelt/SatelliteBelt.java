package com.github.hanyaeger.cosmiccomets.entities.satellitebelt;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.cosmiccomets.entities.satellitebelt.satellite.Satellite;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class SatelliteBelt extends DynamicCompositeEntity implements KeyListener {

    private Satellite satellite1;
    private Satellite satellite2;
    private Satellite satellite3;
    private Satellite satellite4;

    public SatelliteBelt(Coordinate2D initialLocation) {
        super(initialLocation);
        setRotationSpeed(0);
    }

    @Override
    protected void setupEntities() {
        //TODO: Make center of rotation constant
        satellite1 = new Satellite(new Coordinate2D(0, 200));
        satellite1.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(satellite1);

        satellite2 = new Satellite(new Coordinate2D(0, -200));
        satellite2.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(satellite2);

        satellite3 = new Satellite(new Coordinate2D(200,0));
        satellite3.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(satellite3);

        satellite4 = new Satellite(new Coordinate2D(-200,0));
        satellite4.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(satellite4);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        if (set.contains(KeyCode.RIGHT)) {
            setRotationSpeed(-1.5);
        } else if (set.contains(KeyCode.LEFT)) {
            setRotationSpeed(1.5);
        } else if (set.isEmpty()){
            if (getRotationSpeed() > 0){
                setRotationSpeed(getRotationSpeed() - 1);
            } else {
                setRotationSpeed(getRotationSpeed() + 1);
            }
        }
    }
}
