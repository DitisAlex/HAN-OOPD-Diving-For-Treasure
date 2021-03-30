package project.DivingForTreasure.screen;

import project.DivingForTreasure.DivingForTreasure;
import project.DivingForTreasure.interactableObject.Spawner;
import project.DivingForTreasure.player.Player;

/**
 * @author Alex Cheng
 * @author Laurens van Brecht
 */
public class PlayScreen extends Screen {
    private DivingForTreasure world;
    private Player player;
    private Spawner spawner;

    /**
     * Constructor
     * @param world DivingForTreasure
     */
    public PlayScreen(DivingForTreasure world) {
        this.world = world;
        this.player = new Player(world);
        this.spawner = new Spawner(world);
    }

    /**
     * Sets player into world and
     * generates all objects with spawner
     */
    @Override
    public void spawnScreenObjects() {
        world.addGameObject(player, 0, 0);
        spawner.spawnObjects();
    }

    /**
     * Deletes all generated objects
     */
    @Override
    public void deleteScreenObjects() {
        spawner.deleteObjects();
    }
}
