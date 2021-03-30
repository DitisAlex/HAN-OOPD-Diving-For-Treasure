package project.DivingForTreasure.interactableObject.aiding;

import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import project.DivingForTreasure.DivingForTreasure;
import project.DivingForTreasure.interactableObject.InteractableObject;

import java.util.Random;

/**
 * @author Alex Cheng
 * @author Laurens van Brecht
 */
public class OxygenTank extends Aid {
    /**
     * Constructor
     * @param world DivingForTreasure
     */
    public OxygenTank(DivingForTreasure world) {
        super("oxygen-tank.png", world);
    }

    /**
     * [Not in use]
     * Could be used in future to allow diamond being eaten by Shark
     * @param go GameObject
     */
    @Override
    public void gameObjectCollision(GameObject go) {
        //TODO: Can be deleted by GameObject Shark
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
