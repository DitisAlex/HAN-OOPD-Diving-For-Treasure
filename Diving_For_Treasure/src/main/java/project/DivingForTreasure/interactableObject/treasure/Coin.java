package project.DivingForTreasure.interactableObject.treasure;

import nl.han.ica.oopg.objects.GameObject;
import project.DivingForTreasure.DivingForTreasure;

/**
 * @author Alex Cheng
 * @author Laurens van Brecht
 */
public class Coin extends Treasure {
    /**
     * Constructor
     * @param world DivingForTreasure
     */
    public Coin(DivingForTreasure world) {
        super("coin.png", world);
    }

    /**
     * [Not in use]
     * Could be used in future to allow coin being eaten by Shark
     * @param go GameObject
     */
    @Override
    public void gameObjectCollision(GameObject go) {
        //TODO: Can be deleted bij GameObject Shark
    }


    /**
     * [Not in use]
     * Could be used in future to handle what should happen
     * when object collision occurs, such as a sound
     */
    @Override
    public void collisionEvent() {

    }

    /**
     * [Not in use]
     * Could be used in future to allow object to change direction
     */
    @Override
    public void objectUpdate() {

    }
}
