package nl.han.ica.oopg.divingfortreasure;

import nl.han.ica.oopg.objects.GameObject;
import nl.han.ica.oopg.objects.TextObject;
import processing.core.PGraphics;

/**
 * De klasse Score bevat alle functionaliteiten die benodigd is voor het
 * bijhouden van een score en het tonen van deze score.
 * 
 * @author laurensvanbrecht
 *
 */
public class Score extends GameObject {
	/**
	 * Dit zijn alle variabele die gebruikt worden bij het maken van een score
	 * object.
	 */
	private DivingForTreasure world;
	private String text;
	private int count;
	private int score;
	private int textSize;
	TextObject to;

	/**
	 * De constructor van krijgt 4 paramters. Een DivingForTreasure world waar het
	 * score object getekend moet worden. Een String die de text gaat zijn voor het
	 * score object. Een int count die aangeeft op elke rij op het scherm de score
	 * moet staan. Een int beginscore die de score op de beginscore zet.
	 * 
	 * @param world
	 * @param text
	 * @param count
	 * @param beginScore
	 */
	protected Score(DivingForTreasure world, String text, int count, int beginScore) {
		this.world = world;
		this.text = text;
		this.count = count;
		this.score = beginScore;
		this.textSize = 25;
	}

	// Functions
	/**
	 * printScore() zal het score object naar het scherm printen.
	 */
	public void printScore() {
//		System.out.println("Score has been printed");
		this.to = new TextObject(text + score, textSize);
		to.setForeColor(255, 255, 255, 255);
		world.addGameObject(to, 0, textSize * count);
	}

	/**
	 * updateScore() zal ervoor zorgen dat de score steeds wordt gerefreshed.
	 */
	public void updateScore() {
		to.setVisible(false);
		printScore();
	}

	/**
	 * delete() gebruikt worden om een score object te verwijderen van het scherm.
	 */
	protected void delete() {
		world.deleteGameObject(this);
	}

	/**
	 * constrainScore() krijgt een int als parameter. Deze parameter wordt
	 * vervolgens om dit de hoogst mogelijke score te maken.
	 * 
	 * @param int
	 */
	public void constrainScore(int maxScore) {
		if (this.score > maxScore) {
			this.score = maxScore;
		}
	}

	/**
	 * addToScore() krijgt als parameter een int. De huidige score wordt vervolgens
	 * verhoogd met deze int.
	 * 
	 * @param int
	 */
	public void addToScore(int score) {
		this.score += score;
	}

	/**
	 * takeOfScore() krijgt als parameter een int. De huidige score wordt vervolgens
	 * verminderd met deze int.
	 * 
	 * @param int
	 */
	public void takeOfScore(int score) {
		this.score -= score;
	}

	/**
	 * resetScore() krijgt als parameter een int. Deze int wordt dan de huidige
	 * score.
	 * 
	 * @param score
	 */
	public void resetScore(int score) {
		setScore(score);
	}

	// Decrement in percentage
	/**
	 * Om de score af te verminderen zal takeOfScore(double) gebruikt worden. De
	 * parameter is een dubbel die waar 20% van af wordt gehaald. Deze waarde wordt
	 * vervolgens in de huidige score gecast.
	 * 
	 * @param int
	 */
	public void takeOfScore(double score) {
		this.score = (int) (this.score * 0.8);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
	}

	@Override
	public void draw(PGraphics g) {
		// TODO Auto-generated method stub

	}

	// Getters and setters
	/**
	 * getScore() returned de waarde van de huidge score.
	 * 
	 * @return int
	 */
	public int getScore() {
		return score;
	}

	/**
	 * setScore krijgt als parameter een int mee en zet de huidge score
	 * 
	 * @param int
	 */
	public void setScore(int score) {
		this.score = score;
	}
}
