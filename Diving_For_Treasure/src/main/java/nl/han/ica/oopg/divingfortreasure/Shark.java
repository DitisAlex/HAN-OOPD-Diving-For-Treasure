package nl.han.ica.oopg.divingfortreasure;

import java.util.List;
import java.util.Random;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.sound.Sound;

/**
 * Dit is de klasse Shark, deze klasse regelt alle functionaliteiten rond het
 * Haai object.
 * 
 * @author Alex Cheng
 *
 */
public class Shark extends Object {
	/**
	 * Hierin worden de correcte geluidseffecten en afbeelding gekoppeld aan het
	 * object. Ook wordt er verwezen waar dit object getekend mag worden.
	 * 
	 * @param world
	 */
	// Constructor
	protected Shark(DivingForTreasure world) {
		super(world, "shark.png");
	}

	@Override
	public void update() {
		setDirectionSpeed(90, 4);
		if(this.x >= world.getWidth()){
			this.outOfScreen(world);
		}
	}

	/**
	 * Hierin wordt bijgehouden of het haai object in aanraking komt met de speler.
	 * Als dit gebeurd voert hij de action() funcite uit.
	 */
	// Interface ICollidableWithGameObjects functions
	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Player) {
				this.action();
			}
		}
	}


	/**
	 * Deze bestuurt de geluidseffecten van het object en zorgt voor het respawnen
	 * van de speler.
	 */
	// Interface ObjectInteractions functions
	@Override
	public void action() {
		System.out.println("Shark ate player");
//		world.playerIsDead();
//		world.decreaseCoinsCollected();
	}
}
