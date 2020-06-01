package fr.mugiwara.mmorpg;

/**
 * Class Entite
 * @author Sanjeevan
 * @version 1.0
 */
public class Entite {
	
	protected int postition;
	protected String display;
	
	
	/**
	 * Retourne la position de l'entité
	 * @return Integer
	 */
	public int getPosition() {
		
		return this.postition;
	}
	
	
	/**
	 * Renvoie le displayname de l'entité
	 * @return String
	 */
	public String getDisplay() {
		
		return this.display;
		
	}
	
	
}
