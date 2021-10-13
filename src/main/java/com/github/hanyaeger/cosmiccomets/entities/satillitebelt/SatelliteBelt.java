package com.github.hanyaeger.cosmiccomets.entities.satillitebelt;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import com.github.hanyaeger.cosmiccomets.entities.satillitebelt.satillite.Satillite;
import javafx.scene.input.KeyCode;

import java.util.Set;

public class SatelliteBelt extends DynamicCompositeEntity implements KeyListener {

    private Satillite satellite1;
    private Satillite satellite2;
    private Satillite satellite3;
    private Satillite satellite4;

    public SatelliteBelt(Coordinate2D initialLocation) {
        super(initialLocation);
        setRotationSpeed(0);
    }

    @Override
    protected void setupEntities() {
        //TODO: Make center of rotation constant
        satellite1 = new Satillite(new Coordinate2D(0, 200));
        satellite1.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(satellite1);

        satellite2 = new Satillite(new Coordinate2D(0, -200));
        satellite2.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(satellite2);

        satellite3 = new Satillite(new Coordinate2D(200,0));
        satellite3.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(satellite3);

        satellite4 = new Satillite(new Coordinate2D(-200,0));
        satellite4.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        addEntity(satellite4);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        if (set.contains(KeyCode.RIGHT)) {
            setRotationSpeed(-1.5);
        } else if (set.contains(KeyCode.LEFT)) {
            setRotationSpeed(1.5);
        } else if (set.contains(KeyCode.SPACE)) {
            setRotationSpeed(0);
        } else if (set.contains(KeyCode.Z)) {
            satellite1.setOpacity(0);
        } else if (set.contains(KeyCode.X)) {
            satellite2.setVisible(false);
        } else if (set.contains(KeyCode.C)) {
            satellite3.setVisible(false);
        } else if (set.contains(KeyCode.V)) {
            satellite4.setVisible(false);
        } else if (set.contains(KeyCode.N)) {
            satellite1.setVisible(false);
            satellite2.setVisible(false);
        } else if (set.contains(KeyCode.M)) {
            satellite3.setVisible(false);
            satellite4.setVisible(false);
        }
    }
}
