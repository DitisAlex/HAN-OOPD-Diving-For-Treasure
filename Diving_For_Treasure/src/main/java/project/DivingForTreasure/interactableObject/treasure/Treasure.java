package project.DivingForTreasure.interactableObject.treasure;

import project.DivingForTreasure.DivingForTreasure;
import project.DivingForTreasure.interactableObject.InteractableObject;

import java.util.Random;

/**
 * @author Alex Cheng
 * @author Laurens van Brecht
 */
public abstract class Treasure extends InteractableObject {
    /**
     * Constructor
     * @param fileName String
     * @param world DivingForTreasure
     */
    public Treasure(String fileName, DivingForTreasure world) {
        super(fileName, world);
        setDirectionSpeed(0, speed);
    }

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
