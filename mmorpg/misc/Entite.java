package fr.mugiwara.mmorpg.misc;

import fr.mugiwara.mmorpg.game.Game;

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
	
	/**
	 * Faire déplacer l'entité
	 * @param dir String
	 * @return Boolean
	 */
	public boolean deplacer(String dir) {
		int newPos = this.position;
		
		if(dir.equalsIgnoreCase("h")) {
			newPos = this.position - 27;
			if(!Game.map.ifPosFree(newPos)) return false;
		} else if(dir.equalsIgnoreCase("b")) {
			newPos = this.position + 27;
			if(!Game.map.ifPosFree(newPos)) return false;

		} else if(dir.equalsIgnoreCase("d")) {
			newPos = this.position +1;
			if(!Game.map.ifPosFree(newPos)) return false;

		} else if(dir.equalsIgnoreCase("g")) {
			newPos = this.position - 1;
			if(!Game.map.ifPosFree(newPos)) return false;
		} else {
			return false;
		}
		this.position = newPos;
		return true;
		
	}
	
	
}
