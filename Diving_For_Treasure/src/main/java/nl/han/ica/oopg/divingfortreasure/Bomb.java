package nl.han.ica.oopg.divingfortreasure;

import java.util.List;
import java.util.Random;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.sound.Sound;
/** 
 * De Bomb klasse regelt het creëren van het bom object in het spel. 
 * Deze Bomb klasse werkt samen met de BombSet klasse.
 * @author Alex Cheng
 * 
 */
public class Bomb extends Object {
	/**
	 * In de constructor worden de world & sound waardes geïnitieerd zodat ze later gebruikt kunnen worden.
	 *
	 * @param world
	 */
	// Constructor
	public Bomb(DivingForTreasure world) {
		super(world, "bomb.png");
	}

	@Override
	public void action() {
		System.out.println("Player hit bomb");
//		world.playerIsDead();
		world.deleteGameObject(this);
//		world.decreaseCoinsCollected();
	}

	@Override
	public void gameObjectCollisionOccurred(List<GameObject> collidedGameObjects) {
		for (GameObject go : collidedGameObjects) {
			if (go instanceof Player) {
				this.action();
			}
		}
	}
}