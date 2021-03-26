package project.DivingForTreasure.interactableObject.aiding;

import project.DivingForTreasure.DivingForTreasure;
import project.DivingForTreasure.interactableObject.InteractableObject;

import java.util.Random;

public abstract class Aid extends InteractableObject {

    public Aid(String fileName, DivingForTreasure world) {
        super(fileName, world);
        setDirectionSpeed(0, speed);
    }

    @Override
    public boolean objectNotPickedUp() {
        return getY() < 0;
    }

    @Override
    public int determineXSpawn() {
        Random r = new Random();
        return r.nextInt(world.getWidth());
    }

    @Override
    public int determineYSpawn() {
        return world.getHeight();
    }
}
