package project.DivingForTreasure.interactableObject.treasure;

import nl.han.ica.oopg.objects.GameObject;
import project.DivingForTreasure.DivingForTreasure;

public class Diamond extends Treasure {
    public Diamond(DivingForTreasure world) {
        super("diamond.png", world);
    }

    @Override
    public void gameObjectCollision(GameObject go) {
        //TODO: Can be deleted bij GameObject Shark
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
