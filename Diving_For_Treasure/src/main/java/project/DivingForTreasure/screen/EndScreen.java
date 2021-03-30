package project.DivingForTreasure.screen;

import project.DivingForTreasure.DivingForTreasure;

/**
 * @author Alex Cheng
 * @author Laurens van Brecht
 */
public class EndScreen extends Screen {
    private DivingForTreasure world;

    /**
     * Constructor
     * @param world DivingForTreasure
     */
    public EndScreen (DivingForTreasure world) {
        this.world = world;
    }

    /**
     * [Not in use]
     * Could be used in future to spawn end screen text
     */
    @Override
    public void spawnScreenObjects() {

    }

    /**
     * [Not in use]
     * Could be used in future to delete end screen text
     */
    @Override
    public void deleteScreenObjects() {

    }
}
