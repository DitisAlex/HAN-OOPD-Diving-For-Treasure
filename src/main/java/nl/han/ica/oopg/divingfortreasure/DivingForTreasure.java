package nl.han.ica.oopg.divingfortreasure;

import nl.han.ica.oopg.engine.GameEngine;
import nl.han.ica.oopg.sound.Sound;
import nl.han.ica.oopg.userinput.IMouseInput;
import nl.han.ica.oopg.view.View;

/**
 * DivingForTreasure is de main klasse van het project. In deze klasse staat de
 * main van het programma en alle objecten die benodigd zijn voor het laten
 * functioneren van het spel. Hier zullen ook functies staan gebruikt moeten
 * worden voor de functionaliteit van het spel
 * 
 * @author laurensvanbrecht
 *
 */

public class DivingForTreasure extends GameEngine {
	/**
	 * Dit zijn alle game object die gemaakt moeten worden.
	 */
	private Player player;
	private ObjectSpawner objectSpawner;
	private SharkSpawner sharkSpawner;
	private StartButton startButton;
	private Sound backgroundMusic;
	private EndScreen endScreen;
	private boolean gameOver;

	/**
	 * Dit zijn static Strings die gebruikt worden zodat op elke plek de juiste
	 * verwijzing is naar de maplocatie
	 */
	public final static String MEDIA_URL = "src/main/java/images/";
	public final static String AUDIO_URL = "src/main/java/sounds/";

	/**
	 * Dit is de main van het programma. Hier wordt een DivingFOrTreasure object
	 * gemaakt en wordt afgespeeld.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		DivingForTreasure game = new DivingForTreasure();
		game.runSketch();
	}

	/**
	 * setupGame in zoals de naam als zegt de setup voor de game. Hier wordt de
	 * wereld breedte en hoogte vast gesteld en alle variabele geinitaliseerd. Hier
	 * wordt ook alle gameText en gameObjecten gemaakt. De achtergrond wordt ook al
	 * gemaakt hier. De view van het spel wordt hier ook gemaakt.
	 */
	@Override
	public void setupGame() {
		final int WORLDWIDTH = 980;
		final int WORLDHEIGHT = 581;

		createViewWithoutViewport(WORLDWIDTH, WORLDHEIGHT);

		startButton = new StartButton(this, WORLDWIDTH / 2, WORLDHEIGHT / 2, 200 , 100);
		addGameObject(startButton);

//		this.endScreen = new EndScreen(this);
//		this.gameOver = false;
//
//		createGameText();
		initializeSound();
	}

	private void createViewWithoutViewport(int width, int height) {
		View view = new View(width, height);
		view.setBackground(loadImage(DivingForTreasure.MEDIA_URL.concat("underwater-background.png")));
		setView(view);
		size(width, height);
	}

	private void initializeSound(){
		backgroundMusic = new Sound(this, AUDIO_URL.concat("bg-music.mp3"));
		backgroundMusic.loop(-1);
	}

	@Override
	public void update() {
	}

	public void startGame(){
		Object.setSpeed(3);
		player = new Player(this);
		player.spawn();

		sharkSpawner = new SharkSpawner(this);
		objectSpawner = new ObjectSpawner(this, 1);
		objectSpawner.startAlarm();
	}
	/**
	 * Update zal er voor zorgen dat het spel gerefreshed wordt en objecten kunnen
	 * bewegen en dat er interactie met de speler kan zijn.
	 */
//	@Override
//	public void update() {
//		this.gameOver();
//	}

	/**
	 * Hier wordt alle gameText van het spel gemaakt
//	 */
//	public void createGameText() {
//		player.printScoreToScreen();
//		coins.printScoreToScreen();
//		oxygenTanks.printScoreToScreen();
//	}

	// Game functional
	// functions------------------------------------------------------------------------
	/**
	 * gameOver() zal kijken of het de speler nog leeft. Als dit het geval is zal de
	 * functie naar de else vallen. Hier zal dan alle functies die gerund moeten
	 * voor het spel runnen. Als de speler wel game over is zal alles gedelete
	 * worden en zal het eindscherm getekend worden.
	 */
//	private void gameOver() {
//		if (player.checkGameOver()) {
//			// Delete all game objects
//			this.gameOver = true;
//			player.delete();
//			coins.delete();
//			bombs.delete();
//			shark.delete();
//			boat.delete();
//			oxygenTanks.delete();
//			endScreen.draw();
//		} else {
//			oxygenTanks.loseOfOxygen();
//		}
//	}

	/**
	 * restartGame() zal uitgevoerd worden als het spel opnieuw gaat worden
	 * gespeeld. De speler wordt weer op levend gezet en alle opbjecten zullen weer
	 * spawnen.
	 */
	public void restartGame() {
		this.gameOver = false;
	}

//	/**
//	 * playerIsDead() zal uitgevoerd moeten worden als de speler dood is. De speler
//	 * zal een leven verliezen, terug spawnen bij de begin posistie en zijn
//	 * zuurstofgehalte wordt gereset.
//	 */
//	public void playerIsDead() {
//		player.dead();
//		oxygenTanks.resetOxygen();
//	}
//
//	/**
//	 * Als een coin verzameld is zal incrementCoinsCollected() uitgevoerd moeten
//	 * worden. De score zal dan verhoogd worden met de coin. Na dat een coin is
//	 * opgepakt zal er ook een nieuwe coin spawnen meteen.
//	 */
//	public void incrementCoinsCollected() {
//		coins.incrementScore();
//	}
//
//	/**
//	 * Als de speler in aanraking is geweest met een object dat de score moet
//	 * verlagen moet deze functie uitgevoerd worden. De score zal met deze functie
//	 * met een percentage afgenomen worden
//	 */
//	public void decreaseCoinsCollected() {
//		coins.decrementScore();
//	}
//
//	/**
//	 * Als de speler in aanraking komt met een object dat de zuurstofgehalte moet
//	 * verhogen moet deze functie uitgevoerd worden. De zuurstof van de speler zal
//	 * dan toenemen met de waarde van een zuurstoftank.
//	 */
//	public void incrementOxygenLevel() {
//		oxygenTanks.incrementScore();
//	}
//
//	/**
//	 * Als de speler zuurstof moet verliezen moet deze functie uitgevoerd worden. De
//	 * zuurstof van de speler zal dan afnemen met de waarde die daarvoor is
//	 * toegeschreven.
//	 */
//	public void decrementOxygenLevel() {
//		oxygenTanks.decrementScore();
//	}

	/**
	 * Als de speler in aanraking komt met een object die het leven aantal van de
	 * speler moet verhogen, zal deze functie uitgevoerd moeten worden. Het aantal
	 * levens van de speler zal dan toenemen met 1.
//	 */
//	public void incrementLivesLeft() {
//		player.incrementScore();
//	}
//
//	/**
//	 * Als de speler in aanraking komt met een object die het leven aantal van de
//	 * speler moet verlagen zal deze functie uitgevoerd moeten worden. Het aantal
//	 * levens van de speler zal dan verlaagd worden met 1.
//	 */
//	public void decrementLivesLeft() {
//		player.decrementScore();
//	}

	// Getters and Setters
	/**
	 * Dit is de getter van de variable gameOver
	 * 
	 * @return boolean
	 */
	public boolean getGameOver() {
		return gameOver;
	}

	/**
	 * Dit is de setter van de variable gameOver
	 * 
	 * @param gameOver
	 */
	public void setGameOver(boolean gameOver) {
		this.gameOver = gameOver;
	}

}
