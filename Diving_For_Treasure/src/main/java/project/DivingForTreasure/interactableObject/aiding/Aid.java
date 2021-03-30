package project.DivingForTreasure.interactableObject.aiding;

import project.DivingForTreasure.DivingForTreasure;
import project.DivingForTreasure.interactableObject.InteractableObject;

import java.util.Random;

/**
 * @author Alex Cheng
 * @author Laurens van Brecht
 */
public abstract class Aid extends InteractableObject {

    /**
     * Constructor
     * @param fileName String
     * @param world DivingForTreasure
     */
    public Aid(String fileName, DivingForTreasure world) {
        super(fileName, world);
        setDirectionSpeed(0, speed);
    }

    /**
     * Determines at what height object is not picked up
     * @return boolean
     */
    @Override
    public boolean objectNotPickedUp() {
        return getY() < 0;
    }

    /**
     * Determines random X spawn between 0 and worldWidth
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
}
