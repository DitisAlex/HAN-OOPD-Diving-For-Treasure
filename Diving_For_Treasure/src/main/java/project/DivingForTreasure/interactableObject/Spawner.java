package project.DivingForTreasure.interactableObject;

import project.DivingForTreasure.DivingForTreasure;
import project.DivingForTreasure.interactableObject.aiding.OxygenTank;
import project.DivingForTreasure.interactableObject.enemy.Bomb;
import project.DivingForTreasure.interactableObject.enemy.Shark;
import project.DivingForTreasure.interactableObject.treasure.Coin;
import project.DivingForTreasure.interactableObject.treasure.Diamond;

import java.util.ArrayList;

/**
 * @author Alex Cheng
 * @author Laurens van Brecht
 */
public class Spawner {
    private DivingForTreasure world;
    private ArrayList<InteractableObject> objects = new ArrayList<>();

    /**
     * Constructor
     * @param world DivingForTreasure
     */
    public Spawner(DivingForTreasure world) {
        this.world = world;
        setupObjects();
    }

    //Functions

    /**
     * Spawns all the objects in object ArrayList
     */
    public void spawnObjects() {
        for (InteractableObject io: objects) {
            io.spawnObject();
        }
    }

    /**
     * Deletes all the objects in object ArrayList
     */
    public void deleteObjects() {
        for (InteractableObject io: objects) {
            io.deleteObject();
        }
    }

    /**
     * Declares how many of each object should be added
     */
    private void setupObjects() {
        addCoins(8);
        addDiamonds(1);
        addOxygenTanks(3);
        addBombs(5);
        addShark(1);
    }

    //TODO: addToObjects adds the same object multiple times
    // This creates an error for the same object being spawned
//    private void addToObject(InteractableObject object, int amount) {
//        for (int i = 0; i < amount; i++) {
//            objects.add(object);
//        }
//    }

    /**
     * Adds X amount of coins to object ArrayList
     * @param amount int
     */
    private void addCoins(int amount) {
        for (int i = 0; i < amount; i++) {
            objects.add(new Coin(world));
        }
    }

    /**
     * Adds X amount of diamonds to object ArrayList
     * @param amount int
     */
    private void addDiamonds(int amount) {
        for (int i = 0; i < amount; i++) {
            objects.add(new Diamond(world));
        }
    }

    /**
     * Adds X amount of oxygen tanks to object ArrayList
     * @param amount int
     */
    private void addOxygenTanks(int amount) {
        for (int i = 0; i < amount; i++) {
            objects.add(new OxygenTank(world));
        }
    }

    /**
     * Adds X amount of bombs to object ArrayList
     * @param amount int
     */
    private void addBombs(int amount) {
        for (int i = 0; i < amount; i++) {
            objects.add(new Bomb(world));
        }
    }

    /**
     * Adds X amount of sharks to object ArrayList
     * @param amount int
     */
    private void addShark (int amount) {
        for (int i = 0; i < amount; i++) {
            objects.add(new Shark(world));
        }
    }
}
