package nl.han.ica.oopg.divingfortreasure;

import java.util.List;

import nl.han.ica.oopg.collision.ICollidableWithGameObjects;
import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.sound.Sound;

/**
 * OxygenTank klasse is voor het creëren van de zuurstof tanks. Deze klasse
 * werkt samen met de OxygenTankSet klasse.
 * 
 * @author Alex Cheng
 *
 */
public class OxygenTank extends Object {
	/**
	 * De constructor ïnitialiseerd de variabelen. In dit geval verbind hij de
	 * correcte Sprite afbeelding en geluids effect bij de zuurstof tank. En wordt
	 * world aangewezen om te bepalen waar dit object getekend kan worden.
	 * 
	 * @param world
	 */
	// Constructor
	protected OxygenTank(DivingForTreasure world) {
		super(world, "oxygen-tank.png");
	}

	@Override
	public void action() {
		System.out.println("Player collected oxygen tank");
		world.deleteGameObject(this);
//		world.incrementOxygenLevel();
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
