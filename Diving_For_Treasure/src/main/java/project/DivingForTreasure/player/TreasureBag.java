package project.DivingForTreasure.player;

import project.DivingForTreasure.interactableObject.treasure.Treasure;

import java.util.ArrayList;

/**
 * @author Alex Cheng
 * @author Laurens van Brecht
 */
public class TreasureBag {
    private final ArrayList<Treasure> treasures = new ArrayList<>();

    /**
     * Adds collected treasures to treasures arrayList
     * @param t Treasure
     */
    public void addToTreasureBag(Treasure t) {
        treasures.add(t);
    }
}
