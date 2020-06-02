package fr.mugiwara.mmorpg.misc;

/**
 * Class Degre
 * @author Sanjeevan
 * @version 1.0
 */
public class Degre {

	public int degre;
	public int bonus;
	
	/**
	 * Constructeur du Degre
	 * @param degre Integer
	 */
	public Degre(int degre) {
		
		this.degre = degre/3;
		this.bonus = degre%3;

	}
	
	public String getDegre() {
		
		String txt = degre + "D + "+ bonus;
		return txt;
		
	}
	
}
