package com.github.hanyaeger.cosmiccomets.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import com.github.hanyaeger.cosmiccomets.CosmicComets;
import javafx.scene.Cursor;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class RetryButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private final CosmicComets cosmicComets;

    /**
     * @param initialLocation the given location of where the RetryButton gets placed
     * @param cosmicComets the instance of the game
     */
    public RetryButton(Coordinate2D initialLocation, CosmicComets cosmicComets) {
        super(initialLocation, "Retry Mission");
        this.cosmicComets = cosmicComets;
        setFill(Color.WHITE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 32));
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        // Set the scene with ID 1 active (game level scene)
        cosmicComets.setActiveScene(1);
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.GREY);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.YELLOW);
        setCursor(Cursor.DEFAULT);
    }
}
