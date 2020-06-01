package fr.mugiwara.mmorpg;

import java.util.ArrayList;

/**
 * Class Map
 * @author Sanjeevan
 * @version 1.0
 */
public class Map {
	
	private ArrayList<Entite> game_map;
	
	/*
	 * Constructeur de la Map
	 */
	public Map() {
		this.game_map = new ArrayList<Entite>();
	}
	
	/**
	 * Retourne la map
	 * @return ArrayList<Entite>
	 */
	public ArrayList<Entite> getMap() {
		return this.game_map;
	}

	/**
	 * Ajouter une entité à la map
	 * @param Entite
	 */
	public void addEntite(Entite e) {
		game_map.add(e);
	}

}
