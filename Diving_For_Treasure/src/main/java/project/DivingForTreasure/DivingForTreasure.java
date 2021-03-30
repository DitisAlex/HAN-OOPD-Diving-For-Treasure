package project.DivingForTreasure;

import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.view.View;
import project.DivingForTreasure.screen.EndScreen;
import project.DivingForTreasure.screen.Screen;
import project.DivingForTreasure.screen.PlayScreen;

/**
 * @author Alex Cheng
 * @author Laurens van Brecht
 */
public class DivingForTreasure extends GameEngine {
    //Static Variables
    public static String MEDIA_URL = "src/main/java/project/DivingForTreasure/media/images/";
    public static String SOUND_URL = "src/main/java/project/DivingForTreasure/media/sounds/";
    private Screen screen = new PlayScreen(this);

    /**
     * Main Method
     * @param args Arguments
     */
    public static void main(String[] args) {
        DivingForTreasure hw = new DivingForTreasure();
        hw.runSketch();
    }

    /**
     * Setups the game by initializing view properties
     * and goes to first screen
     */
    @Override
    public void setupGame() {
        // Initialize View
        int worldWidth = 980;
        int worldHeight = 581;
        View view = new View(worldWidth, worldHeight);
        setView(view);
        size(worldWidth, worldHeight);
        view.setBackground(loadImage(DivingForTreasure.MEDIA_URL.concat("background.png")));

        // Begin Tutorial
        screen.spawnScreenObjects();
        // End tutorial
    }

    @Override
    public void update() {

    }

    //Functions

    /**
     * Ends the game by switching to end screen
     * and deletes all active objects
     */
    public void goToEndScreen() {
        System.out.println("Going to endscreen");
        screen.deleteScreenObjects();
        screen = new EndScreen(this);
        screen.spawnScreenObjects();
    }
}
