package project.DivingForTreasure.interactableObject.treasure;

import project.DivingForTreasure.DivingForTreasure;
import project.DivingForTreasure.interactableObject.InteractableObject;

import java.util.Random;

public abstract class Treasure extends InteractableObject {

    public Treasure(String fileName, DivingForTreasure world) {
        super(fileName, world);
        setDirectionSpeed(0, speed);
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

    @Override
    public boolean objectNotPickedUp() {
        return getY() < 0;
    }

}
