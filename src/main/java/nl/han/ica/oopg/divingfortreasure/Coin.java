package nl.han.ica.oopg.divingfortreasure;

import java.util.List;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.sound.Sound;

/**
 * De Coin klasse bevat alle functionaliteiten rond het munt object.
 * 
 * @author Alex Cheng
 *
 */
public class Coin extends Object{
	/**
	 * De constructor zorgt ervoor de world geïnitieerd wordt zodat deze later nog
	 * gebruikt kan worden. Ook wordt hier het correctte .mp3 bestand gekoppeld aan
	 * het Coin object.
	 * 
	 * @param world
	 */
	// Constructor
	protected Coin(DivingForTreasure world) {
		super(world, "coin.png");
	}

	@Override
	public void action() {
		System.out.println("Player collect coin");
		world.deleteGameObject(this);
//		world.incrementCoinsCollected();
	}

	/**
	 * Hiermee wordt er gedectecteerd of het coin object in aanraking komt met de
	 * Player object. Als er een collision is gedetecteerd wordt de action() functie
	 * uitgevoerd.
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
}
