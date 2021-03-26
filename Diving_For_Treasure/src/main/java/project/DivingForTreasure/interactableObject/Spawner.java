package project.DivingForTreasure.interactableObject;

import project.DivingForTreasure.DivingForTreasure;
import project.DivingForTreasure.interactableObject.aiding.OxygenTank;
import project.DivingForTreasure.interactableObject.enemy.Bomb;
import project.DivingForTreasure.interactableObject.enemy.Shark;
import project.DivingForTreasure.interactableObject.treasure.Coin;
import project.DivingForTreasure.interactableObject.treasure.Diamond;

import java.util.ArrayList;

public class Spawner {
    private DivingForTreasure world;
    private ArrayList<InteractableObject> objects = new ArrayList<>();

    public Spawner(DivingForTreasure world) {
        this.world = world;
        setupObjects();
    }

    //Functions
    public void spawnObjects() {
        for (InteractableObject io: objects) {
            io.spawnObject();
        }
    }

    public void deleteObjects() {
        for (InteractableObject io: objects) {
            io.deleteObject();
        }
    }

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

    private void addCoins(int amount) {
        for (int i = 0; i < amount; i++) {
            objects.add(new Coin(world));
        }
    }

    private void addDiamonds(int amount) {
        for (int i = 0; i < amount; i++) {
            objects.add(new Diamond(world));
        }
    }

    private void addOxygenTanks(int amount) {
        for (int i = 0; i < amount; i++) {
            objects.add(new OxygenTank(world));
        }
    }

    private void addBombs(int amount) {
        for (int i = 0; i < amount; i++) {
            objects.add(new Bomb(world));
        }
    }

    private void addShark (int amount) {
        for (int i = 0; i < amount; i++) {
            objects.add(new Shark(world));
        }
    }



    //Abstract Functions
    //Override Functions
    //Getters and setters
}
