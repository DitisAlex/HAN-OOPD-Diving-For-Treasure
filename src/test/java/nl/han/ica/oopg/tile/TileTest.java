package nl.han.ica.oopg.tile;

import nl.han.ica.oopg.objects.Sprite;
import processing.core.PImage;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TileTest {

    Tile tile;
    Sprite testSprite = new Sprite(new PImage(50, 50));

    @BeforeEach
    public void setup() {
        tile = new Tile(testSprite);
    }

    @Test
    public void getSpriteWhichHasBeenGivenInTheConstructor() {
        assertEquals(tile.getSprite(), testSprite);
    }

    @Test
    public void setSpriteSizeTo100() {
        int testSize = 100;
        tile.setSpriteSize(testSize);
        assertEquals(tile.getSprite().getHeight(), testSize);
        assertEquals(tile.getSprite().getWidth(), testSize);
    }
}
