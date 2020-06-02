package fr.mugiwara.mmorpg.misc;

import java.util.ArrayList;

import fr.mugiwara.mmorpg.game.Objet;

/**
 * Interface ContainerObjets
 * @author Sanjeevan
 * @version 1.0
 */
public abstract class ContainerObjets {	
	
	// VARIABLES
	
	protected ArrayList<Objet> content;
	protected int used_size = 0;
	protected int max_size; 
	
	/**
	 * Constructeur du sac
	 */
	public ContainerObjets() {
		content = new ArrayList<Objet>();
	}
	
	/**
	 * Permet de voir si il reste une place vide
	 * @return Boolean
	 */
	public boolean spaceFree() {
		if(used_size < max_size) return true;
		
		return false;
	}
	
	/**
	 * Method d'ajout d'objet
	 * @param Objet
	 * @return 
	 */
	public abstract boolean addObjet(Objet o);
	
	
	/**
	 * Method de supression d'objet
	 * @param Objet
	 */
	public abstract boolean removeObjet(Objet o);
	
	/**
	 * Afficher le container
	 */
	public abstract void afficher();

}
