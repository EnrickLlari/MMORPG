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
	
	/**
	 * Afficher les degrés
	 * @return String
	 */
	public String getDegre() {
		
		String txt = degre + "D + "+ bonus;
		return txt;
		
	}
	
	/**
	 * Ajouter des degres
	 * @param Integer points
	 */
	public void addDegre(int points) {
		
		int got = (this.degre * 3) + this.bonus;
		
		got += points;
		
		this.degre = got/3;
		this.bonus = got%3;
		
	}
	
	/**
	 * Récupère une valeur avec les degres
	 * @return Integer
	 */
	public int getValue() {
		
		int i = 0;
		int sum = 0;
		while(i < degre) {
			sum += (int) ((Math.random() * 3) + 1);
			i++;
		}
		
		sum += bonus;
		return sum;
		
	}
	
}
