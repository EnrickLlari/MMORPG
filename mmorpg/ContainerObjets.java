package fr.mugiwara.mmorpg;

import java.util.ArrayList;

/**
 * Class ContainerObjets
 * @author Enrick
 * @version 1.0
 *
 */

public class ContainerObjets {
	
	// VARIABLES
	
	private ArrayList<Objets> objets;
	
	/*
	 * Constructeur de la liste d'Objets
	 */
	
	public ContainerObjets() {
		objets = new ArrayList<Objets>();
		
	}
	
	
	/*
	 * Method d'ajout d'objet
	 * @param Objets
	 */

	public void addObjet(Objets o) {

		objets.add(o);
	}
	
	
	/*
	 * Method de supression d'objet
	 * @param Objets
	 */
	public void removeObjet(Objets o) {

		objets.remove(o);

	}

}
