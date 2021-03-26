package project.DivingForTreasure.interactableObject.enemy;

import nl.han.ica.oopg.objects.GameObject;
import project.DivingForTreasure.DivingForTreasure;

import java.util.Random;

public class Shark extends Enemy {
    public Shark(DivingForTreasure world) {
        super("shark.png", world);
    }

    @Override
    public void direction() {
        setDirectionSpeed(90, speed);
    }

    @Override
    public int determineXSpawn() {
        return 0;
    }

    @Override
    public int determineYSpawn() {
       Random r = new Random();
       return r.nextInt(world.getHeight() - world.getHeight()/2) + world.getHeight()/2;
    }

    @Override
    public boolean objectNotPickedUp() {
        return getX() > world.getWidth();
    }

    @Override
    public void gameObjectCollision(GameObject go) {
        //Nothing
    }

    @Override
    public void collisionEvent() {
        //Nothing
    }

    @Override
    public void objectUpdate() {
        //Nothing
    }
}
