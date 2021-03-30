package project.DivingForTreasure.interactableObject.enemy;

import project.DivingForTreasure.DivingForTreasure;
import project.DivingForTreasure.interactableObject.InteractableObject;

import java.util.Random;

/**
 * @author Alex Cheng
 * @author Laurens van Brecht
 */
public abstract class Enemy extends InteractableObject {

    /**
     * Constructor
     * @param fileName String
     * @param world DivingForTreasure
     */
    public Enemy(String fileName, DivingForTreasure world) {
        super(fileName, world);
        direction();
    }

    /**
     * Abstract method to determine direction
     */
    public abstract void direction();

    /**
     * Determines random number between 0 and worldWidth as X Spawn
     * @return int
     */
    @Override
    public int determineXSpawn() {
        Random r = new Random();
        return r.nextInt(world.getWidth());
    }

    /**
     * Determines Y spawn
     * @return int
     */
    @Override
    public int determineYSpawn() {
        return world.getHeight();
    }

    /**
     * Determines at what height object is not picked up
     * @return boolean
     */
    @Override
    public boolean objectNotPickedUp() {
        return getY() < 0;
    }
}
