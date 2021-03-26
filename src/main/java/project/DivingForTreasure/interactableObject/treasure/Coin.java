package project.DivingForTreasure.interactableObject.treasure;

import nl.han.ica.oopg.objects.GameObject;
import project.DivingForTreasure.DivingForTreasure;

public class Coin extends Treasure {

    public Coin(DivingForTreasure world) {
        super("coin.png", world);
    }

    //Functions
    //Abstract Functions
    //Override Functions
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
