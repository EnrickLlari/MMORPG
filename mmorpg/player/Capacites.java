package fr.mugiwara.mmorpg.player;

import fr.mugiwara.mmorpg.misc.Degre;

/**
 * Class Capacites
 * @author Sanjeevan
 * @version 1.0
 */
public class Capacites {
	// Capacités
	private Degre initiative;
	private Degre attaque;
	private Degre esquive;
	private Degre defense;
	private Degre degat;
	
	/**
	 * Constructeur des capacités
	 */
	public Capacites() {
		
		initiative = new Degre(0);
		attaque = new Degre(0);
		esquive = new Degre(0);
		defense = new Degre(0);
		degat = new Degre(0);
		
	}
	
	/**
	 * Affichier les capacités
	 */
	public void afficher() {
		System.out.println(" * Initiative : " + initiative.getDegre());
		System.out.println(" * Attaque : " + attaque.getDegre());
		System.out.println(" * Esquive : " + esquive.getDegre());
		System.out.println(" * Défense : " + defense.getDegre());
		System.out.println(" * Dégât : " + degat.getDegre());
		
	}

}
