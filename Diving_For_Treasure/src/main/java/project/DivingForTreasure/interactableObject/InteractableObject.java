package project.DivingForTreasure.interactableObject;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import project.DivingForTreasure.DivingForTreasure;
import project.DivingForTreasure.player.Player;

import java.util.List;

/**
 * @author Alex Cheng
 * @author Laurens van Brecht
 */
public abstract class InteractableObject extends SpriteObject implements ICollidableWithGameObjects {
    protected DivingForTreasure world;
    protected int speed;
    private final int START_SPEED = 3;

    /**
     * Constructor
     * @param fileName String
     * @param world DivingForTreasure
     */
    public InteractableObject(String fileName, DivingForTreasure world) {
        super(new Sprite(DivingForTreasure.MEDIA_URL.concat(fileName)));
        this.world = world;
        this.speed = START_SPEED;
    }

    //Functions

    /**
     * Adds object to world at certain location
     */
    public void spawnObject() {
        world.addGameObject(this, determineXSpawn(), determineYSpawn());
    }

    /**
     * Deletes object from world
     */
    public void deleteObject() {
        world.deleteGameObject(this);
    }

    /**
     * Handles what happens when collision with player is detected
     */
    public void collisionWithPlayer() {
        respawnObject();
        collisionEvent();
    }

    /**
     * Respawns object at certain location
     */
    public void respawnObject() {
        setX(determineXSpawn());
        setY(determineYSpawn());
    }

    //Abstract Functions
    public abstract void gameObjectCollision(GameObject go);
    public abstract void collisionEvent();
    public abstract void objectUpdate();
    public abstract boolean objectNotPickedUp();
    public abstract int determineXSpawn();
    public abstract int determineYSpawn();

    //Override Functions
    @Override
    public void update() {
        if (objectNotPickedUp()) {
            respawnObject();
        }
        objectUpdate();
    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject go: collidedGameObjects) {
            if (go instanceof Player) {
                collisionWithPlayer();
            } else {
                gameObjectCollision(go);
            }
        }
    }

    // Getters and setters
    public DivingForTreasure getWorld() {
        return world;
    }

    public void setWorld(DivingForTreasure world) {
        this.world = world;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
