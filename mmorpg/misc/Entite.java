package fr.mugiwara.mmorpg.misc;

import fr.mugiwara.mmorpg.game.Game;
import fr.mugiwara.mmorpg.player.Joueur;

/**
 * Class Entite
 * @author Sanjeevan
 * @version 1.0
 */
public abstract class Entite {
	
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
	 * Tuer l'entité
	 */
	public void mort(Entite tueur) {
		
		if(tueur instanceof Joueur) {
			Joueur jr = (Joueur) tueur;
			jr.getExperience().addExp(3);
		}
		
		Game.map.removeEntite(position);
		
		mortaction();
	}
	
	/**
	 * A redéfinir dans les classes hérités
	 */
	public abstract void mortaction();
	
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
