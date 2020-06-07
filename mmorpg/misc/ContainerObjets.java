package fr.mugiwara.mmorpg.misc;

import java.util.HashMap;

/**
 * Interface ContainerObjets
 * @author Sanjeevan
 * @version 1.0
 */
public abstract class ContainerObjets {	
	
	// VARIABLES
	
	protected HashMap<Objet, Integer> content;
	protected int used_size = 0;
	protected int max_size; 
	
	/**
	 * Constructeur du sac
	 */
	public ContainerObjets() {
		content = new HashMap<Objet, Integer>();
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
	 * Retourne le contenu du container
	 * @return HashMap
	 */
	public HashMap<Objet, Integer> getContent() {
		return this.content;
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
