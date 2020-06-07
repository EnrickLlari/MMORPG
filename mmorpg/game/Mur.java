package fr.mugiwara.mmorpg.game;

import fr.mugiwara.mmorpg.misc.Entite;

/**
 * Class Mur
 * @author Sanjeevan
 * @version 1.0
 *
 */
public class Mur extends Entite{
	
	/**
	 * Constructeur du mur
	 * @param pos Integer
	 */
	public Mur(int pos) {
		this.position = pos;
		this.display = "#";
	}


	@Override
	public void mortaction() {
		return;
		
	}
	

}
