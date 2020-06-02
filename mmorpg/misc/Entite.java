package fr.mugiwara.mmorpg.misc;

/**
 * Class Entite
 * @author Sanjeevan
 * @version 1.0
 */
public class Entite {
	
	protected int position;
	protected String display;
	
	
	/**
	 * Retourne la position de l'entité
	 * @return Integer
	 */
	public int getPosition() {
		
		return this.position;
	}
	
	
	/**
	 * Renvoie le displayname de l'entité
	 * @return String
	 */
	public String getDisplay() {
		
		return this.display;
		
	}
	
	
}
