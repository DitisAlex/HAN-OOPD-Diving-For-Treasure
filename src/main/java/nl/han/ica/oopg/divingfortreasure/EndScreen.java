package nl.han.ica.oopg.divingfortreasure;

import nl.han.ica.oopg.objects.Sprite;
import nl.han.ica.oopg.objects.SpriteObject;
import nl.han.ica.oopg.objects.TextObject;
import nl.han.ica.oopg.userinput.IMouseInput;

/**
 * De klasse EndScreen bevat alle functionaliteiten voor het eind scherm wanneer
 * de speler niet genoeg levens meer heeft.
 * 
 * @author Alex Cheng
 *
 */
public class EndScreen extends SpriteObject implements IMouseInput {
	/**
	 * Hier worden alle textObjects aangemaakt en wordt er aangegeven waar de
	 * objecten getekend mogen worden.
	 */
	private DivingForTreasure world;
	private int textSize;
	TextObject to;
	TextObject title;
	TextObject restart;

	/**
	 * In de constructor worden alle variabelen geïnitialiseerd.
	 * 
	 * @param world
	 */
	protected EndScreen(DivingForTreasure world) {
		super(new Sprite(DivingForTreasure.MEDIA_URL.concat("player.png")));
		this.world = world;
		this.textSize = 50;
	}

	public void draw() {
		printFinalScore();
	}

	/**
	 * Hier worden alle textObjecten gevuld met text en de positie op het
	 * speelscherm waar deze tekst getoont moet worden.
	 */
	public void printFinalScore() {
		this.title = new TextObject("Game Over!", textSize * 2);
		title.setForeColor(255, 255, 255, 255);
		world.addGameObject(title, textSize, textSize * 2);

		this.to = new TextObject("See your results in the top left corner", textSize);
		to.setForeColor(255, 255, 255, 255);
		world.addGameObject(to, textSize, textSize * 4);

		this.restart = new TextObject("Click anywhere to play again!", textSize);
		restart.setForeColor(255, 255, 255, 255);
		world.addGameObject(restart, textSize, textSize * 5);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	/**
	 * Deze functie() zorgt ervoor dat het spel correct wordt herstart als er op het
	 * speelscherm geklikt wordt.
	 */
	@Override
	public void mouseClicked(int x, int y, int button) {
		System.out.println("Mouse clicked");
		if (world.getGameOver()) {
			world.restartGame();
		}
	}
}
