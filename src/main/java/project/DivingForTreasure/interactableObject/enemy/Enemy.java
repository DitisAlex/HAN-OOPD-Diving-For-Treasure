package project.DivingForTreasure.interactableObject.enemy;

import project.DivingForTreasure.DivingForTreasure;
import project.DivingForTreasure.interactableObject.InteractableObject;

import java.util.Random;

public abstract class Enemy extends InteractableObject {

    public Enemy(String fileName, DivingForTreasure world) {
        super(fileName, world);
        direction();
    }

    public abstract void direction();

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
