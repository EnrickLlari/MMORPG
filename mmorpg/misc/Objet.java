package fr.mugiwara.mmorpg.misc;
/**
 * Class Objets
 * @author Enrick
 * @version 1.0
 */

public class Objet {
	
	// VARIABLES 
	private String nom;
	private String display;
	private String capacite;
	private int capacite_value;
	private int cost;
	
	/**
	 * Constructure de l'objet
	 * @param String name
	 * @param String capacite
	 * @param Integer capacite_value
	 * @param Integer cost
	 */
	public Objet(String name, String display, String capacite, int capacite_value, int cost) {
		this.nom = name;
		this.display = display;
		this.capacite = capacite;
		this.capacite_value = capacite_value;
		this.cost = cost;
	}

	/**
	 * Getter du nom
	 * @return String
	 */
	public String getNom() {
		return nom;
	}
	
	public String getDisplay() {
		return display;
	}
	
	/**
	 * Getter de capacite
	 * @return String
	 */
	public String getCapacite() {
		return capacite;
	}
	
	/**
	 * Setter de capacite
	 * @param String capacite
	 */
	public void setCapacite(String capacite) {
		this.capacite = capacite;
	}
	
	/**
	 * Getter capacite valeur
	 * @return Integer
	 */
	public int getCapacite_value() {
		return capacite_value;
	}
	
	/**
	 * Setter de capacite value
	 * @param Integer capacite_value
	 */
	public void setCapacite_value(int capacite_value) {
		this.capacite_value = capacite_value;
	}
	
	/**
	 * Getter de cost
	 * @return Integer
	 */
	public int getCost() {
		return cost;
	}
	
	/**
	 * Setter de cost
	 * @param Integer cost
	 */
	public void setCost(int cost) {
		this.cost = cost;
	}
}
