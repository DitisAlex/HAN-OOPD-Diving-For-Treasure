package nl.han.ica.oopg.objects;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import processing.core.PGraphics;
import processing.core.PImage;

public class SpriteObjectTest {

	SpriteObject obj;
	PImage img;
	
	@BeforeEach
	public void setup()
	{
		img = new PImage(20, 20);
		Sprite sprite = new Sprite(img);
		obj = new FakeSpriteObject(sprite);
	}
	
	@Test
	public void getPImageShouldReturnTheCorrectSprite()
	{
		assertEquals(img, obj.getImage());
	}
	
	@Test
	public void drawShouldDrawTheImageOnTheGraphics()
	{
		PGraphics g = new PGraphics();
		g.setSize(img.width, img.height);
		
		obj.draw(g);

		g.loadPixels();
	
		assertArrayEquals(img.pixels, g.pixels);
	}
	
	private class FakeSpriteObject extends SpriteObject {

		public FakeSpriteObject(Sprite sprite) {
			super(sprite);
		}

		@Override
		public void update() {
			
		}
	}
}
