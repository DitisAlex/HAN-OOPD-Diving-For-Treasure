package project.DivingForTreasure.screen;

/**
 * @author Alex Cheng
 * @author Laurens van Brecht
 */
public abstract class Screen {
    /**
     * Abstract method to spawn correct objects into the
     * world
     */
    public abstract void spawnScreenObjects();

    /**
     * Abstract method to delete all spawned objects in the
     * world
     */
    public abstract void deleteScreenObjects();
}
