package fr.mugiwara.mmorpg.EntityMisc;

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
	 * Retourne initiative
	 * @return Degre
	 */
	public Degre getInitiative() {
		return initiative;
	}
	
	/**
	 * Ajouter de l'initiative
	 * @param degre
	 */
	public void addInitiative(int degre) {
		initiative.addDegre(degre);
	}
	
	/**
	 * Ajouter de l'attaque
	 * @param degre
	 */
	public void addAttaque(int degre) {
		attaque.addDegre(degre);
	}
	
	/**
	 * Ajouter de l'esquive
	 * @param degre
	 */
	public void addEsquive(int degre) {
		esquive.addDegre(degre);
	}
	
	/**
	 * Ajouter de la défense
	 * @param degre
	 */
	public void addDefense(int degre) {
		defense.addDegre(degre);
	}
	
	/**
	 * Ajouter des dégâts
	 * @param degre
	 */
	public void addDegat(int degre) {
		degat.addDegre(degre);
	}
	
	/**
	 * Retourne attaque
	 * @return Degre
	 */
	public Degre getAttaque() {
		return attaque;
	}
	
	/**
	 * Retourne esquive
	 * @return Degre
	 */
	public Degre getEsquive() {
		return esquive;
	}
	
	/**
	 * Retourne defense
	 * @return Degre
	 */
	public Degre getDefense() {
		return defense;
	}
	
	/**
	 * Retourne degat
	 * @return Degre
	 */
	public Degre getDegat() {
		return degat;
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
