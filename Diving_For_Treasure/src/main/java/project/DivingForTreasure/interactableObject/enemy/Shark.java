package project.DivingForTreasure.interactableObject.enemy;

import nl.han.ica.oopg.objects.GameObject;
import project.DivingForTreasure.DivingForTreasure;

import java.util.Random;

/**
 * @author Alex Cheng
 * @author Laurens van Brecht
 */
public class Shark extends Enemy {
    /**
     * Constructor
     * @param world
     */
    public Shark(DivingForTreasure world) {
        super("shark.png", world);
    }

    /**
     * Sets direction to 90 degree
     */
    @Override
    public void direction() {
        setDirectionSpeed(90, speed);
    }

    /**
     * Determines X spawn
     * @return int
     */
    @Override
    public int determineXSpawn() {
        return 0;
    }


    /**
     * Determines Y spawn as random number between worldHeight - worldHeight/2 & worldHeight/2
     * @return int
     */
    @Override
    public int determineYSpawn() {
       Random r = new Random();
       return r.nextInt(world.getHeight() - world.getHeight()/2) + world.getHeight()/2;
    }

    /**
     * Determines at what width object is not picked up
     * @return boolean
     */
    @Override
    public boolean objectNotPickedUp() {
        return getX() > world.getWidth();
    }

    /**
     * [Not in use]
     * Could be used in future to make shark die to bomb
     * @param go GameObject
     */
    @Override
    public void gameObjectCollision(GameObject go) {
        //Nothing
    }

    /**
     * [Not in use]
     * Could be used in future to play sound when Shark eats something
     */
    @Override
    public void collisionEvent() {
        //Nothing
    }

    /**
     * [Not in use]
     * Could be used in future to make shark have AI to swim after player
     */
    @Override
    public void objectUpdate() {
        //Nothing
    }
}
