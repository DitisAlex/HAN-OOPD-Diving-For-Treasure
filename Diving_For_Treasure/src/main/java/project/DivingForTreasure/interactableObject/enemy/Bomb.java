package project.DivingForTreasure.interactableObject.enemy;

import nl.han.ica.oopg.objects.GameObject;
import project.DivingForTreasure.DivingForTreasure;

public class Bomb extends Enemy {
    public Bomb(DivingForTreasure world) {
        super("bomb.png", world);
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

    @Override
    public void direction() {
        setDirectionSpeed(0, speed);
    }
}
