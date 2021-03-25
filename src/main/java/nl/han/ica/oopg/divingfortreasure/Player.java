package nl.han.ica.oopg.divingfortreasure;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;

/**
 * De klasse Player zal het kunnen maken en besturen van een Player mogelijk
 * maken. Deze klasse zal alle functionaliteiten bevatten omtrent de speler van
 * het spel.
 * 
 * @author laurensvanbrecht
 *
 */
public class Player extends SpriteObject {
	// Variables
	/**
	 * Dit zijn alle variabele die benodigd zijn voor de klasse Player.
	 */
	private DivingForTreasure world;
	private float beginSpawnX, beginSpawnY;
	private float playerXPosition, playerYPosition;
	private Score lives;
	private int speed;

	// Constructor
	/**
	 * Dit is de constrcutor van de speler klasse. De enigste parameter is een
	 * DivingForTreasure wereld zodat een speler gespeeld kan worden in het spel.
	 * Alle overige variabelen worden hier zelf geinitaliseerd.
	 * 
	 * @param world
	 */
	public Player(DivingForTreasure world) {
		super(new Sprite(DivingForTreasure.MEDIA_URL.concat("player.png")));
		this.world = world;
		this.beginSpawnX = 900;
		this.beginSpawnY = 0;
		this.speed = 4;
		lives = new Score(world, "Lives left:", 2, 5);
	}

	// Functions
	/**
	 * Voor de speler moet er een spawn functie zijn zodat de speler toegevoegd kan
	 * worden aan het speelscherm.
	 */
	public void spawn() {
		world.addGameObject(this, this.beginSpawnX, this.beginSpawnY);
	}

	/**
	 * Om te controleren of een speler nog genoeg levens heeft om te spelen zal de
	 * functies checkGameOver() uitgevoerd moeten worden. Als een speler nog genoeg
	 * levens heeft zal deze functie false returnen anders zal de functie true
	 * returnen.
	 * 
	 * @return boolean
	 */
//	public boolean checkGameOver() {
//		if (lives.getScore() <= 0) {
//			return true;
//		}
//		return false;
//	}
//
//	/**
//	 * Om de levens van de speler te resetten zal de reset() functie uitgevoerd
//	 * moeten worden.
//	 */
//	public void reset() {
//		lives.resetScore(5);
//	}
//
//	/**
//	 * Om de speler te kunnen deleten zal de functie delete() toegepast moeten
//	 * worden.
//	 */
//	public void delete() {
//		world.deleteGameObject(this);
//	}
//
//	/**
//	 * Als de speler dood komt te gaan zal de functie dead() uitgevoerd moeten
//	 * worden. Een leven van de speler zal afgenomen worden en vervolgens zal de
//	 * speler opnieuw spawnen bij de boot.
//	 */
//	public void dead() {
//		world.decrementLivesLeft();
//		world.deleteGameObject(this);
//		this.spawn();
//	}
//
//	/**
//	 * Om de snelheid van de speler te versnellen zal speedUp() uitgevoerd moeten
//	 * worden.
//	 */
//	public void speedUp() {
//		this.speed = 6;
//	}
//
//	/**
//	 * Om de snelheid van de speler te normalizeren zal normalSpeed() uitgevoerd
//	 * moeten worden.
//	 */
//	public void normalSpeed() {
//		this.speed = 4;
//	}
//
//	/**
//	 * Om de snelheid van de speler te verminderen zal decrement() uitgevoerd moeten
//	 * worden.
//	 */
//	public void decrementSpeed() {
//		this.speed = 2;
//	}
//
//	/**
//	 * Om te controleren of de speler of het scherm blijft zal inScreen() uitgevoerd
//	 * moeten worden. Als de speler x of y posistie uit het scherm gaat zal de
//	 * direction van de speler aangepast worden zodat de speler binnen het scherm
//	 * blijft. Als de speler niet op het scherm zal inScreen() false returnen en
//	 * anders zal de functie true returnen.
//	 *
//	 * @return boolean
//	 */
	public boolean inScreen() {
		final int speed = 2;
		this.playerXPosition = this.getCenterX();
		this.playerYPosition = this.getCenterY();
		if (playerXPosition < 0) {
			setDirectionSpeed(90, speed);
			return false;
		}
		if (playerXPosition > world.getWidth()) {
			setDirectionSpeed(270, speed);
			return false;
		}
		if (playerYPosition > world.getHeight()) {
			setDirectionSpeed(0, speed);
			return false;
		}
		if (playerYPosition < 0) {
			setDirectionSpeed(180, speed);
			return false;
		}
		return true;
	}

//	// ObjectScore implements
//	@Override
//	public void printScoreToScreen() {
//		// TODO Auto-generated method stub
//		lives.printScore();
//	}
//
//	@Override
//	public void incrementScore() {
//		// TODO Auto-generated method stub
//		lives.addToScore(1);
//		lives.updateScore();
//	}
//
//	@Override
//	public void decrementScore() {
//		// TODO Auto-generated method stub
//		lives.takeOfScore(1);
//		lives.updateScore();
//	}

	// GameObject abstract functions
	@Override
	public void update() {
		this.inScreen();
	}

	@Override
	public void keyPressed(int keyCode, char key) {
		if (inScreen()) {
			if (keyCode == world.LEFT) {
				setDirectionSpeed(270, speed);
			}
			if (keyCode == world.RIGHT) {
				setDirectionSpeed(90, speed);
			}
			if (keyCode == world.UP) {
				setDirectionSpeed(0, speed);
			}
			if (keyCode == world.DOWN) {
				setDirectionSpeed(180, speed);
			}
		}
	}
}
