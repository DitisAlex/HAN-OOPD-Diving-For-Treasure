package project.DivingForTreasure.player;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.objects.TextObject;
import project.DivingForTreasure.DivingForTreasure;
import project.DivingForTreasure.interactableObject.aiding.Aid;
import project.DivingForTreasure.interactableObject.enemy.Enemy;
import project.DivingForTreasure.interactableObject.treasure.Treasure;
import project.DivingForTreasure.supportingObject.Clock;

import java.util.ArrayList;
import java.util.List;

public class Player extends SpriteObject implements ICollidableWithGameObjects {
    private DivingForTreasure world;
    private TreasureBag treasureBag = new TreasureBag();
    private Clock oxygenClock = new Clock(world, 750);
    private ArrayList<TextObject> textObjects = new ArrayList<>();
    private int lives = 3;
    private int score = 0;
    private int oxygen = 100;

    public Player(DivingForTreasure world) {
        super(new Sprite(DivingForTreasure.MEDIA_URL.concat("player.png")));
        this.world = world;
        this.displayStats(30, 0);
    }

    //Functions
    private void gameOver() {
        if (lives <= 0) {
            lives = 0;
            this.deletePlayerStats();
            this.displayStats(40, (world.getWidth()/2)-40 * 2);
            world.deleteGameObject(this);
            world.goToEndScreen();
        }
    }

    private void respawn() {
        resetOxygen();
        setY(0);
        setX(0);
    }

    private void incrementScore() {
        final int scoreGranted = 1;
        score += scoreGranted;
    }

    private void incrementOxygen() {
        final int oxygenGranted = 15;
        final int maxOxygen = 100;
        oxygen += oxygenGranted;
        if (oxygen > maxOxygen) oxygen = maxOxygen;
    }

    private void decrementScore() {
        final int scoreDecrement = score%12;
        score -= scoreDecrement;
    }

    private void decrementOxygen() {
        final int decrementOxygen = 1;
        oxygen -= decrementOxygen;
    }

    private void depleteOxygen() {
        if (oxygenClock.clockPassed()) {
            decrementOxygen();
            deletePlayerStats();
            this.displayStats(30, 0);
        }
    }

    private void resetOxygen() {
        final int fullOxygen = 100;
        oxygen = fullOxygen;
    }

    private void checkOxygenLevel() {
        if (oxygen <= 0) {
            decrementLives();
            respawn();
        }
    }

    private void decrementLives() {
        lives -=1;
    }

    //TODO: .getHeight() and .getWidth() set don't work.
    private void preventOutOfBounds() {
        final int maxWidth = world.getWidth();
        final int maxHeight = world.getHeight();
        if (this.getX() > maxWidth) {
            this.setX(maxWidth);
        } else if (this.getX() < 0) {
            this.setX(0);
        } else if (this.getY() > maxHeight) {
            this.setY(maxHeight);
        } else if (this.getY() < 0) {
            this.setY(0);
        }
    }

    private void displayStats(int fontsize, int x) {
        textObjects.clear();
        textObjects.add(new TextObject("Lives: " + lives, fontsize));
        textObjects.add(new TextObject("Oxygen: " + oxygen, fontsize));
        textObjects.add(new TextObject("Score: " + score, fontsize));
        int i = 0;
        for (TextObject to : textObjects) {
            to.setForeColor(255, 255, 255,255);
            world.addGameObject(to, x, i * fontsize);
            i++;
        }
        i = 0;
    }

    private void deletePlayerStats () {
        for (TextObject to: textObjects) {
            world.deleteGameObject(to);
        }
    }

    private void printPlayerStats() {
        System.out.println("Player Lives: " + lives);
        System.out.println("Player Oxygen: " + oxygen);
        System.out.println("Player Score: " + score);
    }
    //Abstract Functions
    //Override Functions
    @Override
    public void update() {
        this.gameOver();
        this.preventOutOfBounds();
        this.depleteOxygen();
        this.checkOxygenLevel();
    }

    @Override
    public void keyPressed(int keyCode, char key) {
        final float speed = 5;
        if (keyCode == world.LEFT) {
            setDirectionSpeed(270, speed);
        } else if (keyCode == world.RIGHT) {
            setDirectionSpeed(90, speed);
        } else if (keyCode == world.UP) {
            setDirectionSpeed(0, speed);
        } else if (keyCode == world.DOWN) {
            setDirectionSpeed(180, speed);
        }
    }

    @Override
    public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
        for (GameObject go: collidedGameObjects) {
            deletePlayerStats();
            if (go instanceof Treasure) {
                treasureBag.addToTreasureBag((Treasure)go);
                incrementScore();
            } else if (go instanceof Aid) {
                incrementOxygen();
            } else if (go instanceof Enemy) {
                decrementScore();
                decrementLives();
                respawn();
            }
            this.displayStats(30, 0);
        }
    }

    //Getters and setters
    public DivingForTreasure getWorld() {
        return world;
    }

    public void setWorld(DivingForTreasure world) {
        this.world = world;
    }

    public TreasureBag getTreasureBag() {
        return treasureBag;
    }

    public void setTreasureBag(TreasureBag treasureBag) {
        this.treasureBag = treasureBag;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getOxygen() {
        return oxygen;
    }

    public void setOxygen(int oxygen) {
        this.oxygen = oxygen;
    }
}
