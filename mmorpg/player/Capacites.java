package fr.mugiwara.mmorpg.player;

import fr.mugiwara.mmorpg.misc.Degre;

/**
 * Class Capacites
 * @author Sanjeevan
 * @version 1.0
 */
public class Capacites {
	// Capacit�s
	private Degre initiative;
	private Degre attaque;
	private Degre esquive;
	private Degre defense;
	private Degre degat;
	
	/**
	 * Constructeur des capacit�s
	 */
	public Capacites() {
		
		initiative = new Degre(0);
		attaque = new Degre(0);
		esquive = new Degre(0);
		defense = new Degre(0);
		degat = new Degre(0);
		
	}
	
	/**
	 * Affichier les capacit�s
	 */
	public void afficher() {
		System.out.println(" * Initiative : " + initiative.getDegre());
		System.out.println(" * Attaque : " + attaque.getDegre());
		System.out.println(" * Esquive : " + esquive.getDegre());
		System.out.println(" * D�fense : " + defense.getDegre());
		System.out.println(" * D�g�t : " + degat.getDegre());
		
	}

}
