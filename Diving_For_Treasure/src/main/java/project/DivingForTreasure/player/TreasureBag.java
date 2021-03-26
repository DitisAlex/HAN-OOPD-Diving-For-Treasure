package project.DivingForTreasure.player;

import project.DivingForTreasure.interactableObject.treasure.Treasure;

import java.util.ArrayList;

public class TreasureBag {
    private final ArrayList<Treasure> treasures = new ArrayList<>();
    //Functions
    public void addToTreasureBag(Treasure t) {
        treasures.add(t);
    }
    //Abstract Functions
    //Override Functions
    //Getters and setters

}
