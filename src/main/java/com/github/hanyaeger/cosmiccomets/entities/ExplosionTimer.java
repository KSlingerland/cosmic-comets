package com.github.hanyaeger.cosmiccomets.entities;

import com.github.hanyaeger.api.Timer;

public class ExplosionTimer extends Timer {

    private final Explosion explosion;

    /**
     * Set the explosion instance in this Object
     * @param explosion the given explosion instance
     */
    public ExplosionTimer(final Explosion explosion) {
        super(40);
        this.explosion = explosion;
    }

    @Override
    public void onAnimationUpdate(final long timestamp) {
        explosion.updateFrame();
    }
}
