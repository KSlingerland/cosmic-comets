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

public class QuitButton extends TextEntity implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {
    private final CosmicComets cosmicComets;

    /**
     * @param initialLocation the given location of where the StartButton gets placed
     * @param cosmicComets the instance of the game
     */
    public QuitButton(Coordinate2D initialLocation, CosmicComets cosmicComets) {
        super(initialLocation, "Quit game");
        this.cosmicComets = cosmicComets;

        setFill(Color.ORANGE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 32));
    }

    @Override
    public void onMouseButtonPressed(MouseButton button, Coordinate2D coordinate2D) {
        // Stop and close the game
        cosmicComets.quit();
    }

    @Override
    public void onMouseEntered() {
        setFill(Color.LIGHTYELLOW);
        setCursor(Cursor.HAND);
    }

    @Override
    public void onMouseExited() {
        setFill(Color.ORANGE);
        setCursor(Cursor.DEFAULT);
    }
}
