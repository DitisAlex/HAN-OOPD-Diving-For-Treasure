package project.DivingForTreasure.interactableObject.aiding;

import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import project.DivingForTreasure.DivingForTreasure;
import project.DivingForTreasure.interactableObject.InteractableObject;

import java.util.Random;

public class OxygenTank extends Aid {
    public OxygenTank(DivingForTreasure world) {
        super("oxygen-tank.png", world);
    }

    @Override
    public void gameObjectCollision(GameObject go) {
        //TODO: Can be deleted by GameObject Shark
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
