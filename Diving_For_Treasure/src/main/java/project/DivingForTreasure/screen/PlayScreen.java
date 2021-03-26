package project.DivingForTreasure.screen;

import project.DivingForTreasure.DivingForTreasure;
import project.DivingForTreasure.interactableObject.Spawner;
import project.DivingForTreasure.player.Player;

public class PlayScreen extends Screen {
    private DivingForTreasure world;
    private Player player;
    private Spawner spawner;
    public PlayScreen(DivingForTreasure world) {
        this.world = world;
        this.player = new Player(world);
        this.spawner = new Spawner(world);
    }
    // Functions
    @Override
    public void spawnScreenObjects() {
        world.addGameObject(player, 0, 0);
        spawner.spawnObjects();
    }

    @Override
    public void deleteScreenObjects() {
        spawner.deleteObjects();
    }
    // Abstract Functions
    // Override Functions
    // Getters and setters
}
