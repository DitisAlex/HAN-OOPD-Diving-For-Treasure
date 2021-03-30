package project.DivingForTreasure.interactableObject.enemy;

import nl.han.ica.oopg.objects.GameObject;
import project.DivingForTreasure.DivingForTreasure;

/**
 * @author Alex Cheng
 * @author Laurens van Brecht
 */
public class Bomb extends Enemy {
    /**
     * Constructor
     * @param world DivingForTreasure
     */
    public Bomb(DivingForTreasure world) {
        super("bomb.png", world);
    }

    /**
     * Sets direction to 0 degree
     */
    @Override
    public void direction() {
        setDirectionSpeed(0, speed);
    }

    /**
     * [Not in use]
     * Could be used in future to detonate when hitting other objects
     * @param go GameObject
     */
    @Override
    public void gameObjectCollision(GameObject go) {
        //Nothing
    }

    /**
     * [Not in use]
     * Could be used in future to play sound upon detonating
     */
    @Override
    public void collisionEvent() {
        //Nothing
    }

    /**
     * [Not in use]
     * Could be used in future to change direction
     */
    @Override
    public void objectUpdate() {
        //Nothing
    }
}
