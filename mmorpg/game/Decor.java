package fr.mugiwara.mmorpg.game;

import fr.mugiwara.mmorpg.misc.Entite;
import fr.mugiwara.mmorpg.misc.Objet;

/**
 * Class Decor
 * @author Sanjeevan
 * @version 1.0
 */
public class Decor extends Entite{
	
	private Objet objet;
	
	/**
	 * Constructeur de Decord
	 * @param pos Interger
	 * @param display String
	 */
	public Decor(int pos, String display, Objet objet) {
		
		this.position = pos;
		
		this.display = display;
		
		this.objet = objet;
		
		Game.map.addEntite(this);
		
	}
	
	public Objet getObjet() {
		return objet;
	}

	@Override
	public void mortaction() {
		return;
		
	}
	
}
